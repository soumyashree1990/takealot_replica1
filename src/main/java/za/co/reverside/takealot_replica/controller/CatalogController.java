package za.co.reverside.takealot_replica.controller;


import org.springframework.web.bind.annotation.*;
import za.co.reverside.takealot_replica.Model.Category;
import za.co.reverside.takealot_replica.Model.Product;
import za.co.reverside.takealot_replica.Model.SubCategory;
import za.co.reverside.takealot_replica.Service.CategoryConfigService;
import za.co.reverside.takealot_replica.Service.ProductConfigService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CatalogController {

    private CategoryConfigService categoryConfigurationService;

    private ProductConfigService productConfigurationService;

    private ServletContext context;
//	@Autowired
//	private CartService cartService;

    private String accountsTemplatePage = "template/accountInformation";

    private String homePage = "home";

    private String categoryPage = "category";

    private String accountsPage = "account";

    private static final Logger logger = LoggerFactory
            .getLogger(CatalogController.class);

    /**
     * Catalog Controller method which retrieves the information required in the
     * application home page(Categories,SubCategories,Featured Items)
     *
     *
     * @param Model
     * @return Home Page View
     */
    @GetMapping("/page")
    public String returnHomePage(Model model, HttpServletRequest request) {
        Map<Category, List<SubCategory>> categoryMap = new HashMap<Category, List<SubCategory>>();
        logger.info("Processing information for home page");
        if (categoryMap.isEmpty()) {
            categoryMap = categoryConfigurationService.getCategoriesMap();
        }
        if (context.getAttribute("categoryMap") == null) {
            context.setAttribute("categoryMap", categoryMap);
        }
        List<Product> featProdList = new ArrayList<Product>();
        if (featProdList.isEmpty()) {
            model.addAttribute("featProd",
                    productConfigurationService.getFeaturedProducts());
        }
        return getHomePage();
    }

    @GetMapping("/cateogry")
    public String fetchProductsByCategory(Model model,
                                          @RequestParam("category") String categoryName,
                                          HttpServletRequest request) {
        List<Product> categoryProducts = categoryConfigurationService
                .getProductsByCategory(categoryName);
        model.addAttribute("catProds", categoryProducts);
        return getCategoryPage();
    }

    @GetMapping("/subcateogry")
    public String fetchProductsBySubCategory(Model model,
                                             @RequestParam("subcategory") String subCategoryName,
                                             HttpServletRequest request) {
        List<Product> subCategoryProducts = categoryConfigurationService
                .getProductsBySubCategory(subCategoryName);
        model.addAttribute("subCatProds", subCategoryProducts);
        return getCategoryPage();
    }

    @GetMapping("/account")
    public String getAccountsPage(Model model, HttpServletRequest request) {
        model.addAttribute("page", accountsTemplatePage);
        return getAccountPage();
    }

    public String getAccountPage() {
        return accountsPage;
    }

    public String getCategoryPage() {
        return categoryPage;
    }

    public String getHomePage() {
        return homePage;
    }
}