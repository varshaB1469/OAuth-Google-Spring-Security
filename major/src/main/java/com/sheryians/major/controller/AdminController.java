package com.sheryians.major.controller;

import com.sheryians.major.dto.ProductDto;
import com.sheryians.major.model.Category;
import com.sheryians.major.model.Product;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String UploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;
   @GetMapping("/admin")
    public String admin(){
       return "adminHome";
   }
   @GetMapping("/admin/categories")
    public String getCat(Model model){
       model.addAttribute("categories", categoryService.getAllCategories());
       return "categories";
   }

   @GetMapping("/admin/categories/add")
    public String addCat(Model model){
       model.addAttribute("category",new Category());
       return "categoriesAdd";
   }

    @PostMapping("/admin/categories/add")
    public String postAddCat(@ModelAttribute("category") Category category){
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable  Integer id){
       categoryService.removeCategoryById(id);
       return  "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable Integer id , Model model){
        Optional<Category> category = categoryService.getCategoryById(id);
        if(category.isPresent()){
            model.addAttribute("category" , category.get());
            return "categoriesAdd";
        }else{
            return "404";
        }
    }


    //Product Section
    @GetMapping("/admin/products")
    public String getProducts(Model model){
       model.addAttribute("products", productService.getAllProducts());
       return "products";
    }

    @GetMapping("/admin/products/add")
    public String addProducts(Model model){
       model.addAttribute("productDTO", new ProductDto());
       model.addAttribute("categories" , categoryService.getAllCategories());
       return "productsAdd";
    }

    @PostMapping ("/admin/products/add")
    public String addProductsPost(@ModelAttribute("productDTO") ProductDto productDto,
                                    @RequestParam("productImage") MultipartFile file,
                                    @RequestParam("imgName") String imgName ) throws IOException {

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setCategory(categoryService.getCategoryById(productDto.getCategoryId()).get());
        product.setPrice(productDto.getPrice());
        product.setWeight(productDto.getWeight());
        product.setDescription(productDto.getDescription());
        String imageUUID;
        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(UploadDir,imageUUID);
            Files.write(fileNameAndPath,file.getBytes());
        }else{
            imageUUID = imgName;
        }
        product.setImageName(imageUUID);

        productService.createProduct(product);


       return "redirect:/admin/products";

    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
       productService.deleteProduct(id);
       return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProduct(Model model,@PathVariable Long id){
       Product product = productService.getProduct(id).get();
       ProductDto productDto = new ProductDto();

       productDto.setId(product.getId());
       productDto.setName(product.getName());
       productDto.setPrice(product.getPrice());
       productDto.setWeight(product.getWeight());
       productDto.setCategoryId(product.getCategory().getId());
       productDto.setDescription(product.getDescription());
       productDto.setImageName(product.getImageName());

       model.addAttribute("categories", categoryService.getAllCategories());
       model.addAttribute("productDTO", productDto );
       return "productsAdd";
    }



}
