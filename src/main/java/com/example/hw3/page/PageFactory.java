/*package com.example.hw3.page;

import com.example.hw3.model.enums.PageType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PageFactory {
    private final Map<PageType, Page> pageMap;

    public PageFactory(List<Page> menuSelects) {
        this.pageMap = menuSelects.stream()
                .collect(Collectors.toMap(Page::getType, menuSelect ->menuSelect));
    }

    public Page getPage(PageType type) {
        return pageMap.get(type);
    }
}*/
