package com.shu.nitin.companies.zalando;

import java.util.Arrays;
import java.util.List;

public class TechnicalInterview {
    public static void main(String[] args) {
        Article a1 = new Article("1", "PumaShoe", "Footwear", 10);
        Article a2 = new Article("1", "AddidasShoe", "Footwear", 20);
        Article a3 = new Article("1", "Shoe", "Footwear", 30);

        List<Article> articles = Arrays.asList(a1, a2,a3);
        articles.stream().map(article -> article.getPrice()).reduce(0, Integer::sum));
        articles.stream().filter(article -> article.getPrice() > 100).collect(Collectors.toList())
    }

    class Article {
        private String id;
        private String name;
        private String category;
        private int price;

        public Article(String id, String name, String category, int price) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the category
         */
        public String getCategory() {
            return category;
        }

        /**
         * @param category the category to set
         */
        public void setCategory(String category) {
            this.category = category;
        }

        public int getPrice() {
            return price;
        }

    }
}
