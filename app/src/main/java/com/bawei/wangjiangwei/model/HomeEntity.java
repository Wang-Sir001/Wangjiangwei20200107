package com.bawei.wangjiangwei.model;

import java.util.List;

public class HomeEntity {
    public String message;
    public String status;
    public List<Home> result;

    public static class Home{
        public String categoryName;
        public List<Product> shoppingCartList;

        public static class Product{
            public String commodityId;
            public String commodityName;
            public String count;
            public String pic;
            public String price;

        }

    }
}
