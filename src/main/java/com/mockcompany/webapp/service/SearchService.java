package com.mockcompany.webapp.service;

import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SearchService {

    private final ProductItemRepository productItemRepository;

    @Autowired
    public SearchService(ProductItemRepository productItemRepository) {
        this.productItemRepository = productItemRepository;
    }

    /*
     * This is a simple implementation that loops over all the items and does the filtering in Java.
     * A better implementation would do most if not all the filtering in a query and then finalize or
     * rank the results in Java.  From the SearchControllerSpec, we need to meet the following requirements:
     *   1. query can be contained within either the name or description of the item
     *   2. query string is treated as case-insensitive meaning Hi will match hi, hI, Hi, or HI
     *   3. If the query is wrapped in quotes, only EXACT matches of name/description will be returned
     */
    public Collection<ProductItem> search(String query) {

        Iterable<ProductItem> allItems = this.productItemRepository.findAll();
        List<ProductItem> itemList = new ArrayList<>();
        boolean exactMatch = false;

        if(query.startsWith("\"") && query.endsWith("\"")) {
            exactMatch = true;                                  // Extract the quotes
            query = query.substring(1, query.length() - 1);
        } else {
            query = query.toLowerCase();                        // Handle case-insensitivity by converting to lowercase first
        }

        for (ProductItem item : allItems) {
            boolean nameMatch;
            boolean descriptionMatch;

            if (exactMatch) {
                nameMatch =query.equals(item.getName());
                descriptionMatch = query.equals(item.getDescription());
            } else {                                           // ignore case check, normalize everything to lowercase
                nameMatch = item.getName().toLowerCase().contains(query);
                descriptionMatch = item.getDescription().toLowerCase().contains(query);
            }

            if (nameMatch || descriptionMatch) {
                itemList.add(item);
            }
        }

        return itemList;
    }
}
