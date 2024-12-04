package com.example.btl.model;

import com.example.btl.R;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    // Phương thức trả về danh sách sản phẩm
    public static List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();

        // Danh sách sản phẩm
        productList.add(new Product("iPhone 15 Pro Max", "34.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.7 inch Super Retina XDR\n• Camera: 48MP\n• Pin: 4323 mAh\n• CPU: A17 Pro",
                "Đây là một trong những sản phẩm mới nhất của Apple với hiệu năng mạnh mẽ và camera tuyệt vời."));

        productList.add(new Product("Samsung Galaxy S23 Ultra", "29.990.000đ", R.drawable.s22_ultra,
                "• Màn hình: 6.8 inch Dynamic AMOLED\n• Camera: 200MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 2",
                "Sản phẩm flagship của Samsung với thiết kế sang trọng và tính năng vượt trội."));

        productList.add(new Product("Google Pixel 8 Pro", "25.990.000đ", R.drawable.google_pixel_8_pro_7_,
                "• Màn hình: 6.7 inch LTPO OLED\n• Camera: 50MP\n• Pin: 5050 mAh\n• CPU: Google Tensor G3",
                "Một trong những smartphone tốt nhất cho việc chụp ảnh với tính năng AI mạnh mẽ."));

        productList.add(new Product("Xiaomi 13 Pro", "23.990.000đ", R.drawable.xiaomi_13_pro,
                "• Màn hình: 6.73 inch AMOLED\n• Camera: 50MP\n• Pin: 4820 mAh\n• CPU: Snapdragon 8 Gen 2",
                "Xiaomi 13 Pro mang lại trải nghiệm cao cấp với hiệu suất tuyệt vời."));

        productList.add(new Product("OnePlus 11", "22.990.000đ", R.drawable.one,
                "• Màn hình: 6.7 inch AMOLED\n• Camera: 50MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 2",
                "Thiết kế đẹp mắt, hiệu năng mạnh mẽ, và giá cả hợp lý."));

        productList.add(new Product("Sony Xperia 1 V", "31.990.000đ", R.drawable.sony_xperia_1,
                "• Màn hình: 6.5 inch 4K HDR OLED\n• Camera: 12MP + 12MP + 12MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 2",
                "Sản phẩm chuyên biệt cho những ai yêu thích chụp ảnh và video chuyên nghiệp."));

        productList.add(new Product("Vivo X90 Pro", "26.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.78 inch AMOLED\n• Camera: 50MP + 50MP + 12MP\n• Pin: 4870 mAh\n• CPU: MediaTek Dimensity 9200",
                "Vivo X90 Pro có camera tốt và thiết kế hiện đại."));

        productList.add(new Product("Oppo Find X5 Pro", "29.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.7 inch LTPO AMOLED\n• Camera: 50MP + 13MP + 50MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Thiết kế cao cấp và camera chụp ảnh chuyên nghiệp."));

        productList.add(new Product("Realme GT 2 Pro", "20.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.7 inch AMOLED\n• Camera: 50MP + 50MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Realme GT 2 Pro mang lại hiệu suất tốt với mức giá hợp lý."));

        productList.add(new Product("Xiaomi 12T Pro", "24.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.67 inch AMOLED\n• Camera: 200MP + 8MP + 2MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8+ Gen 1",
                "Camera chính 200MP mang lại chất lượng hình ảnh ấn tượng."));

        productList.add(new Product("Nokia G60", "10.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.58 inch IPS LCD\n• Camera: 50MP + 5MP + 2MP\n• Pin: 4500 mAh\n• CPU: Snapdragon 695 5G",
                "Nokia G60 là smartphone giá rẻ với hiệu suất ổn định."));

        productList.add(new Product("Honor 70", "16.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.67 inch OLED\n• Camera: 54MP + 50MP + 2MP\n• Pin: 4800 mAh\n• CPU: Snapdragon 778G",
                "Honor 70 có thiết kế đẹp và hiệu năng tốt cho công việc hàng ngày."));

        // Thêm 38 sản phẩm khác
        productList.add(new Product("iPhone 14 Pro", "28.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.1 inch Super Retina XDR\n• Camera: 48MP\n• Pin: 3200 mAh\n• CPU: A16 Bionic",
                "Sản phẩm được nhiều người yêu thích với hiệu năng vượt trội."));

        productList.add(new Product("Samsung Galaxy Z Fold4", "39.990.000đ", R.drawable.product_image1,
                "• Màn hình: 7.6 inch AMOLED\n• Camera: 50MP + 12MP + 10MP\n• Pin: 4400 mAh\n• CPU: Snapdragon 8+ Gen 1",
                "Điện thoại gập với khả năng đa nhiệm tuyệt vời."));

        productList.add(new Product("Huawei P50 Pro", "22.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.6 inch OLED\n• Camera: 50MP + 40MP + 13MP + 64MP\n• Pin: 4360 mAh\n• CPU: Snapdragon 888",
                "Sản phẩm nổi bật với camera chất lượng cao."));

        productList.add(new Product("Xiaomi Redmi Note 11 Pro", "7.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.67 inch AMOLED\n• Camera: 108MP + 8MP + 2MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio G96",
                "Điện thoại tầm trung với camera ấn tượng và pin lâu."));

        productList.add(new Product("Realme 9 Pro+", "10.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.4 inch AMOLED\n• Camera: 50MP + 8MP + 2MP\n• Pin: 4500 mAh\n• CPU: MediaTek Dimensity 920",
                "Sản phẩm tầm trung với hiệu năng mạnh mẽ và giá hợp lý."));

        productList.add(new Product("Oppo Reno8 Pro", "17.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.7 inch AMOLED\n• Camera: 50MP + 8MP + 2MP\n• Pin: 4500 mAh\n• CPU: MediaTek Dimensity 8100-Max",
                "Thiết kế mỏng nhẹ và hiệu năng tốt cho mọi nhu cầu sử dụng."));

        productList.add(new Product("Vivo V21", "12.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.44 inch AMOLED\n• Camera: 64MP + 8MP + 2MP\n• Pin: 4000 mAh\n• CPU: MediaTek Dimensity 800U",
                "Điện thoại selfie với camera trước 44MP cho chất lượng hình ảnh tốt."));

        productList.add(new Product("Nokia 3310 3G", "1.490.000đ", R.drawable.product_image1,
                "• Màn hình: 2.4 inch\n• Camera: 2MP\n• Pin: 1200 mAh\n• CPU: không áp dụng",
                "Điện thoại cổ điển với thiết kế bền bỉ và thời lượng pin cực lâu."));

        productList.add(new Product("Motorola Edge 30", "13.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.5 inch OLED\n• Camera: 50MP + 50MP\n• Pin: 4400 mAh\n• CPU: Snapdragon 778G",
                "Sản phẩm với màn hình lớn và hiệu năng ổn định."));

        productList.add(new Product("Asus ROG Phone 6", "29.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.78 inch AMOLED\n• Camera: 50MP + 13MP + 5MP\n• Pin: 6000 mAh\n• CPU: Snapdragon 8+ Gen 1",
                "Điện thoại chơi game với hiệu suất cực cao và thiết kế đặc biệt."));

        productList.add(new Product("Sony Xperia 5 IV", "22.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.1 inch OLED\n• Camera: 12MP + 12MP + 12MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Sản phẩm chất lượng với khả năng quay video và chụp ảnh chuyên nghiệp."));

        productList.add(new Product("Honor Magic 4 Pro", "27.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.81 inch OLED\n• Camera: 50MP + 50MP + 64MP\n• Pin: 4600 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Thiết kế đẹp và nhiều tính năng nổi bật cho người dùng yêu thích công nghệ."));

        productList.add(new Product("Nubia Red Magic 7", "17.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.8 inch AMOLED\n• Camera: 64MP + 8MP + 2MP\n• Pin: 4500 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Điện thoại gaming với thiết kế đặc biệt và hiệu năng vượt trội."));

        productList.add(new Product("Poco F4 GT", "12.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.67 inch AMOLED\n• Camera: 64MP + 8MP + 2MP\n• Pin: 4700 mAh\n• CPU: Snapdragon 8 Gen 1",
                "Sản phẩm gaming với giá cả hợp lý và tính năng mạnh mẽ."));

        productList.add(new Product("ZTE Axon 20", "10.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.92 inch AMOLED\n• Camera: 64MP + 8MP + 2MP + 2MP\n• Pin: 4220 mAh\n• CPU: Snapdragon 765G",
                "Điện thoại đầu tiên trên thế giới với camera ẩn dưới màn hình."));

        productList.add(new Product("LG Velvet", "11.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.8 inch P-OLED\n• Camera: 48MP + 8MP + 5MP\n• Pin: 4300 mAh\n• CPU: Snapdragon 845",
                "Sản phẩm có thiết kế đẹp và camera đa chức năng."));

        productList.add(new Product("HTC U12+", "12.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.0 inch Super LCD\n• Camera: 12MP + 16MP\n• Pin: 3500 mAh\n• CPU: Snapdragon 845",
                "Điện thoại với hiệu năng ổn định và thiết kế sang trọng."));

        productList.add(new Product("Alcatel 3X", "5.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.52 inch IPS LCD\n• Camera: 16MP + 5MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio P22",
                "Sản phẩm giá rẻ với thiết kế bắt mắt và tính năng cơ bản."));

        productList.add(new Product("Tecno Camon 19", "6.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.8 inch IPS LCD\n• Camera: 64MP + 2MP + 0.08MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio G85",
                "Sản phẩm tốt cho việc chụp ảnh và giải trí."));

        productList.add(new Product("Infinix Zero 5G", "7.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.78 inch IPS LCD\n• Camera: 48MP + 13MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Dimensity 900",
                "Điện thoại 5G với thiết kế hiện đại và hiệu suất tốt."));

        productList.add(new Product("Lava Agni 2", "9.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.78 inch AMOLED\n• Camera: 50MP + 5MP + 2MP\n• Pin: 4700 mAh\n• CPU: MediaTek Dimensity 1080",
                "Điện thoại giá rẻ với camera chất lượng và hiệu suất ổn định."));

        productList.add(new Product("Panasonic Eluga I7", "4.990.000đ", R.drawable.product_image1,
                "• Màn hình: 5.0 inch IPS LCD\n• Camera: 13MP\n• Pin: 4000 mAh\n• CPU: MediaTek MT6737",
                "Điện thoại cơ bản với thời lượng pin tốt."));

        productList.add(new Product("ZTE Blade V30", "6.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.67 inch IPS LCD\n• Camera: 16MP + 8MP + 2MP + 2MP\n• Pin: 5000 mAh\n• CPU: Unisoc T610",
                "Sản phẩm giá rẻ với thiết kế đẹp và tính năng cơ bản."));

        productList.add(new Product("Sony Xperia 10 IV", "15.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.0 inch OLED\n• Camera: 12MP + 8MP + 8MP\n• Pin: 5000 mAh\n• CPU: Snapdragon 695 5G",
                "Điện thoại tầm trung với camera tốt và thời lượng pin dài."));

        productList.add(new Product("Samsung Galaxy A54", "10.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.4 inch Super AMOLED\n• Camera: 50MP + 12MP + 5MP\n• Pin: 5000 mAh\n• CPU: Exynos 1380",
                "Sản phẩm tầm trung với nhiều tính năng hấp dẫn."));

        productList.add(new Product("Xiaomi Poco M5", "5.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.58 inch IPS LCD\n• Camera: 50MP + 2MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio G99",
                "Điện thoại giá rẻ với hiệu năng tốt cho nhu cầu cơ bản."));

        productList.add(new Product("Vivo Y21", "6.490.000đ", R.drawable.product_image1,
                "• Màn hình: 6.51 inch IPS LCD\n• Camera: 13MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio P35",
                "Sản phẩm giá rẻ với thiết kế bắt mắt và thời lượng pin tốt."));

        productList.add(new Product("Nokia G20", "5.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.5 inch IPS LCD\n• Camera: 48MP + 5MP + 2MP + 2MP\n• Pin: 5050 mAh\n• CPU: MediaTek Helio G35",
                "Điện thoại cơ bản với camera chất lượng và thời lượng pin lâu dài."));

        productList.add(new Product("Oppo A78", "7.990.000đ", R.drawable.product_image1,
                "• Màn hình: 6.56 inch IPS LCD\n• Camera: 50MP + 2MP\n• Pin: 5000 mAh\n• CPU: MediaTek Helio G99",
                "Sản phẩm tầm trung với hiệu năng ổn định và thiết kế đẹp."));

        return productList;
    }
}
