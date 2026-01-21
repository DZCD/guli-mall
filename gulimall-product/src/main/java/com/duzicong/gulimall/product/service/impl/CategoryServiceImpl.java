package com.duzicong.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.common.utils.Query;

import com.duzicong.gulimall.product.dao.CategoryDao;
import com.duzicong.gulimall.product.entity.CategoryEntity;
import com.duzicong.gulimall.product.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>());

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1.查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }

        // 2.构建父子关系映射（性能优化：从O(n²)优化到O(n)）
        Map<Long, List<CategoryEntity>> parentChildrenMap = entities.stream()
                .collect(Collectors.groupingBy(CategoryEntity::getParentCid));

        // 3.找到所有一级分类并构建树形结构
        List<CategoryEntity> level1Categories = parentChildrenMap.getOrDefault(0L, Collections.emptyList());

        // 4.递归构建完整的树形结构（不修改原始entities）
        return level1Categories.stream()
                .map(category -> buildTreeNode(category, parentChildrenMap))
                .sorted(Comparator.comparing(
                        CategoryEntity::getSort,
                        Comparator.nullsLast(Comparator.naturalOrder())
                ))
                .collect(Collectors.toList());
    }

    /**
     * 递归构建树形节点（无副作用）
     *
     * @param parent              父节点
     * @param parentChildrenMap   父子关系映射
     * @return 构建好的树形节点（包含已排序的子节点列表）
     */
    private CategoryEntity buildTreeNode(CategoryEntity parent, Map<Long, List<CategoryEntity>> parentChildrenMap) {
        // 获取当前节点的所有子节点
        List<CategoryEntity> children = parentChildrenMap.getOrDefault(parent.getCatId(), Collections.emptyList());

        // 递归构建每个子节点的树形结构
        List<CategoryEntity> buildChildren = new ArrayList<>();
        for (CategoryEntity child : children) {
            buildChildren.add(buildTreeNode(child, parentChildrenMap));
        }

        // 对子节点进行排序
        buildChildren.sort(Comparator.comparing(
                CategoryEntity::getSort,
                Comparator.nullsLast(Comparator.naturalOrder())
        ));

        // 设置子节点列表（只设置新创建的树形结构，不影响原始entities）
        parent.setChildren(buildChildren);

        return parent;
    }

}