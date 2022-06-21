package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.model.ProductItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class SearchController {

    private final SearchController searchService;

    @Autowired
    public SearchController(SearchController searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/api/products/search")
    public Collection<ProductItem> search(@RequestParam("query") String query) {
        return this.searchService.search(query);
    }
}
