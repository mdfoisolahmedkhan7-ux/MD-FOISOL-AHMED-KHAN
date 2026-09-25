package com.example.data.sample

import com.example.R
import com.example.data.model.Dish
import com.example.data.model.MenuCategory
import com.example.data.model.Restaurant

object FictionalRestaurantsPart1 {

    val restaurants: List<Restaurant> = listOf(
        // 1. Bella Vista Trattoria
        Restaurant(
            id = "rest_101",
            name = "Bella Vista Trattoria",
            cuisines = listOf("Italian", "Pasta", "Woodfired Pizza"),
            rating = 4.8f,
            totalRatingsCount = "3.2k+",
            priceRange = "$$",
            description = "Authentic Tuscan pastas and hand-stretched pizzas prepared with imported San Marzano tomatoes and extra virgin olive oil.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 2.4f,
            costForTwo = 28.0,
            offerText = "20% OFF on Handmade Pastas",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "42 Cypress Boulevard, Downtown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_101_1",
                    name = "Signature Dishes",
                    dishes = listOf(
                        Dish("d_101_1", "rest_101", "Truffle Tagliolini", "Handmade egg pasta with black winter truffles, butter, and 24-month aged Parmigiano Reggiano.", 18.50, true),
                        Dish("d_101_2", "rest_101", "Woodfired Margherita DOC", "San Marzano tomatoes, fresh buffalo mozzarella, fresh basil, and extra virgin olive oil.", 14.00, true),
                        Dish("d_101_3", "rest_101", "Osso Buco alla Milanese", "Slow-braised veal shank served over golden saffron risotto.", 24.00, false),
                        Dish("d_101_4", "rest_101", "Penne all'Arrabbiata", "Penne tossed in spicy garlic tomato sauce with fresh chili flakes.", 13.50, true),
                        Dish("d_101_5", "rest_101", "Classic Tiramisu", "Espresso-soaked ladyfingers layered with sweet mascarpone cream and cocoa powder.", 7.50, true),
                        Dish("d_101_6", "rest_101", "Crispy Calamari Fritti", "Tender calamari rings dusted in seasoned semolina flour, served with lemon aioli.", 11.00, false)
                    )
                )
            )
        ),

        // 2. Royal Nawabi Feast
        Restaurant(
            id = "rest_102",
            name = "Royal Nawabi Feast",
            cuisines = listOf("Indian", "Biryani", "Mughlai"),
            rating = 4.7f,
            totalRatingsCount = "5.8k+",
            priceRange = "$$",
            description = "Rich Awadhi curries, fragrant handi biryanis, and succulent kebabs inspired by the royal kitchens of Lucknow.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 30,
            distanceKm = 1.9f,
            costForTwo = 24.0,
            offerText = "Flat 50% OFF up to $8 | Code ZOMATO50",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "88 Heritage Crescent, Old Quarter",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_102_1",
                    name = "Nawabi Specialties",
                    dishes = listOf(
                        Dish("d_102_1", "rest_102", "Dum Awadhi Chicken Biryani", "Aromatic long-grain basmati rice layered with spiced chicken and saffron, slow-cooked in a sealed clay pot.", 14.99, false, isBestseller = true),
                        Dish("d_102_2", "rest_102", "Galouti Kebab Melt", "Finely minced smoked lamb patties infused with 32 secret spices, served with sheermal bread.", 12.50, false),
                        Dish("d_102_3", "rest_102", "Shahi Paneer Lababdar", "Cottage cheese simmered in velvety tomato, melon seed, and cashew gravy.", 11.99, true),
                        Dish("d_102_4", "rest_102", "Dal Makhani Grand", "Black lentils slow-simmered for 24 hours with butter and cream.", 9.50, true),
                        Dish("d_102_5", "rest_102", "Garlic Butter Naan", "Tandoor-baked leavened flatbread brushed with crushed garlic and melted butter.", 3.50, true),
                        Dish("d_102_6", "rest_102", "Saffron Kesar Phirni", "Chilled ground rice pudding flavored with green cardamom and saffron strands.", 5.00, true)
                    )
                )
            )
        ),

        // 3. Tokyo Bento & Roll
        Restaurant(
            id = "rest_103",
            name = "Tokyo Bento & Roll",
            cuisines = listOf("Japanese", "Sushi", "Bento"),
            rating = 4.9f,
            totalRatingsCount = "4.1k+",
            priceRange = "$$$",
            description = "Artisanal sushi rolls, fresh sashimi platters, and balanced bento boxes crafted by master sushi chefs.",
            deliveryTimeMin = 30,
            deliveryTimeMax = 40,
            distanceKm = 3.8f,
            costForTwo = 45.0,
            offerText = "Free Edamame on orders above $30",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "15 Sakura Avenue, Uptown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_103_1",
                    name = "Sushi & Bento",
                    dishes = listOf(
                        Dish("d_103_1", "rest_103", "Dragon Roll Deluxe", "Crispy tempura prawn and avocado wrapped with thinly sliced eel and sweet unagi glaze.", 16.00, false, isBestseller = true),
                        Dish("d_103_2", "rest_103", "Salmon Sashimi Platter (8 Pcs)", "Premium cuts of fresh Atlantic salmon served with freshly grated wasabi and pickled ginger.", 18.50, false),
                        Dish("d_103_3", "rest_103", "Chicken Katsu Bento Box", "Crispy panko-breaded chicken cutlet with tonkatsu sauce, steamed rice, gyoza, and seaweed salad.", 15.50, false),
                        Dish("d_103_4", "rest_103", "Spicy Tuna Crunch Roll", "Fresh chopped ahi tuna tossed in sriracha sesame mayo with tempura flakes.", 13.00, false),
                        Dish("d_103_5", "rest_103", "Steamed Pork Gyoza (6 Pcs)", "Pan-seared Japanese dumplings filled with seasoned pork and scallions.", 7.50, false),
                        Dish("d_103_6", "rest_103", "Matcha Green Tea Ice Cream", "Smooth artisan ice cream made with ceremonial grade Kyoto matcha.", 5.50, true)
                    )
                )
            )
        ),

        // 4. Cantina El Fuego
        Restaurant(
            id = "rest_104",
            name = "Cantina El Fuego",
            cuisines = listOf("Mexican", "Tacos", "Tex-Mex"),
            rating = 4.6f,
            totalRatingsCount = "2.9k+",
            priceRange = "$",
            description = "Vibrant street tacos, loaded burritos, and house-made guacamole bursting with authentic Mexican flavors.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 25,
            distanceKm = 1.6f,
            costForTwo = 18.0,
            offerText = "Taco Tuesday: Buy 2 Get 1 Free",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "70 Sun Valley Road, Westside",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_104_1",
                    name = "Tacos & Burritos",
                    dishes = listOf(
                        Dish("d_104_1", "rest_104", "Birria Quesatacos (3 Pcs)", "Slow-braised beef brisket folded in grilled corn tortillas with melted Oaxaca cheese and rich consommé dip.", 12.99, false, isBestseller = true),
                        Dish("d_104_2", "rest_104", "Al Pastor Street Tacos", "Marinated charred pork with caramelized roasted pineapple, white onions, and cilantro.", 10.50, false),
                        Dish("d_104_3", "rest_104", "El Fuego Monster Burrito", "Flour tortilla stuffed with carne asada, pinto beans, Mexican rice, guacamole, and salsa verde.", 12.00, false),
                        Dish("d_104_4", "rest_104", "Loaded Nachos Supreme", "Crisp tortilla chips topped with warm queso blanco, black beans, jalapenos, and sour cream.", 9.50, true),
                        Dish("d_104_5", "rest_104", "Cinco de Leches Cake", "Moist sponge cake soaked in five sweetened milks with cinnamon dust.", 6.00, true),
                        Dish("d_104_6", "rest_104", "Cinnamon Sugar Churros", "Freshly fried churro pastries served with warm dark Mexican chocolate dip.", 5.50, true)
                    )
                )
            )
        ),

        // 5. Smokey Oak BBQ
        Restaurant(
            id = "rest_105",
            name = "Smokey Oak BBQ",
            cuisines = listOf("American", "Barbecue", "Smoked Ribs"),
            rating = 4.7f,
            totalRatingsCount = "3.8k+",
            priceRange = "$$",
            description = "Texas-style low and slow pit barbecue smoked over aged post oak wood for 14 hours.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 3.0f,
            costForTwo = 32.0,
            offerText = "Free Cornbread with any Platter",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "12 Smokehouse Way, East Valley",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_105_1",
                    name = "Pitmaster Cuts",
                    dishes = listOf(
                        Dish("d_105_1", "rest_105", "14-Hour Smoked Beef Brisket", "Half pound of prime cut beef brisket with a peppered bark, served with pickled onions.", 19.50, false, isBestseller = true),
                        Dish("d_105_2", "rest_105", "St. Louis Smoked Rib Rack", "Tender pork ribs glazed in sweet molasses BBQ sauce, falling off the bone.", 22.00, false),
                        Dish("d_105_3", "rest_105", "Pulled Pork Sandwich", "Hickory-smoked shredded pork shoulder piled high on a brioche bun with creamy coleslaw.", 12.50, false),
                        Dish("d_105_4", "rest_105", "Smoked Jalapeno Cheddar Sausage", "Juicy coarse-ground pork sausage linked with fiery jalapeno chunks and cheddar.", 8.50, false),
                        Dish("d_105_5", "rest_105", "Three-Cheese Mac and Cheese", "Elbow macaroni baked in sharp cheddar, gouda, and gruyere with a toasted panko crust.", 6.50, true),
                        Dish("d_105_6", "rest_105", "Warm Skillet Peach Cobbler", "Sweet caramelized peaches topped with flaky buttermilk biscuit crust and vanilla cream.", 7.00, true)
                    )
                )
            )
        ),

        // 6. Sakura Ramen House
        Restaurant(
            id = "rest_106",
            name = "Sakura Ramen House",
            cuisines = listOf("Japanese", "Ramen", "Noodles"),
            rating = 4.8f,
            totalRatingsCount = "6.5k+",
            priceRange = "$$",
            description = "Rich 18-hour tonkotsu broths, springy handmade noodles, and melt-in-your-mouth chashu pork belly.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 30,
            distanceKm = 2.1f,
            costForTwo = 26.0,
            offerText = "Flat $4 OFF on orders over $20",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "33 Lantern Lane, Little Tokyo",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_106_1",
                    name = "Ramen Bowls",
                    dishes = listOf(
                        Dish("d_106_1", "rest_106", "Signature Black Garlic Tonkotsu", "Rich pork bone broth infused with roasted black garlic oil, tender chashu, menma, and ajitsuke tamago.", 15.50, false, isBestseller = true),
                        Dish("d_106_2", "rest_106", "Spicy Miso Ramen", "Fermented red miso broth with ground spiced pork, sweet corn, scallions, and chili oil.", 14.50, false),
                        Dish("d_106_3", "rest_106", "Shoyu Chicken Ramen", "Clear chicken dashi broth with bamboo shoots, nori sheet, and grilled chicken breast slices.", 13.50, false),
                        Dish("d_106_4", "rest_106", "Vegetarian Truffle Shiitake Ramen", "Creamy mushroom vegetable broth with pan-fried tofu, bok choy, and truffle drizzle.", 14.00, true),
                        Dish("d_106_5", "rest_106", "Crispy Chicken Karaage", "Japanese fried chicken thigh marinated in ginger, garlic, and soy sauce, served with spicy kewpie mayo.", 8.00, false),
                        Dish("d_106_6", "rest_106", "Takoyaki Octopus Balls (5 Pcs)", "Savory batter balls filled with tender octopus chunks, topped with bonito flakes and sweet brown sauce.", 7.50, false)
                    )
                )
            )
        ),

        // 7. Bangkok Street Kitchen
        Restaurant(
            id = "rest_107",
            name = "Bangkok Street Kitchen",
            cuisines = listOf("Thai", "Curry", "Noodles"),
            rating = 4.5f,
            totalRatingsCount = "2.7k+",
            priceRange = "$$",
            description = "Fiery wok-tossed pad thai, fragrant green curries, and refreshing lemongrass broths true to Bangkok night markets.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 28,
            distanceKm = 1.7f,
            costForTwo = 22.0,
            offerText = "20% OFF | Code THAITREAT",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "56 Orchid Street, Riverside",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_107_1",
                    name = "Wok & Curries",
                    dishes = listOf(
                        Dish("d_107_1", "rest_107", "Classic Shrimp Pad Thai", "Stir-fried rice noodles with jumbo shrimp, tofu, bean sprouts, crushed peanuts, and lime wedge.", 13.99, false, isBestseller = true),
                        Dish("d_107_2", "rest_107", "Thai Green Curry Chicken", "Creamy coconut milk simmered with green curry paste, bamboo shoots, Thai basil, and chicken.", 13.50, false),
                        Dish("d_107_3", "rest_107", "Tom Yum Goong Soup", "Spicy and sour broth infused with lemongrass, kaffir lime leaves, galangal, and succulent prawns.", 9.00, false),
                        Dish("d_107_4", "rest_107", "Pineapple Fried Rice", "Jasmine rice stir-fried with cashews, raisins, eggs, and sweet pineapple chunks.", 11.50, true),
                        Dish("d_107_5", "rest_107", "Crispy Veg Spring Rolls (4 Pcs)", "Golden fried wrappers filled with shredded cabbage, carrots, and glass noodles.", 6.00, true),
                        Dish("d_107_6", "rest_107", "Mango Sticky Rice", "Sweet glutinous sticky rice bathed in coconut cream and served with ripe mango slices.", 6.50, true)
                    )
                )
            )
        ),

        // 8. The Velvet Cheeseburger
        Restaurant(
            id = "rest_108",
            name = "The Velvet Cheeseburger",
            cuisines = listOf("American", "Burgers", "Fast Food"),
            rating = 4.6f,
            totalRatingsCount = "7.1k+",
            priceRange = "$",
            description = "Lacy-edge smash burgers, melted American cheese, and golden hand-cut fries dripping with secret house sauce.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 22,
            distanceKm = 1.3f,
            costForTwo = 16.0,
            offerText = "Free Milkshake on Combo Orders",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "101 Broadway Avenue, Midtown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_108_1",
                    name = "Smash Burgers & Shakes",
                    dishes = listOf(
                        Dish("d_108_1", "rest_108", "Double Velvet Smash", "Two seared Angus beef patties, double American cheese, grilled onions, pickles, and velvet sauce on potato bun.", 9.99, false, isBestseller = true),
                        Dish("d_108_2", "rest_108", "Bacon Truffle Melt", "Angus patty, crispy applewood bacon, Swiss cheese, and roasted garlic truffle aioli.", 11.50, false),
                        Dish("d_108_3", "rest_108", "Crispy Buttermilk Hot Chicken", "Golden fried chicken thigh coated in cayenne pepper butter with crunchy coleslaw.", 10.00, false),
                        Dish("d_108_4", "rest_108", "Animal Style Loaded Fries", "Crispy fries topped with melted cheese, caramelized onions, and house burger spread.", 5.50, true),
                        Dish("d_108_5", "rest_108", "Salted Caramel Pretzel Shake", "Creamy vanilla ice cream blended with salted caramel sauce and crushed pretzel bits.", 5.00, true),
                        Dish("d_108_6", "rest_108", "Beer-Battered Onion Rings", "Crispy jumbo sweet onion rings served with zesty barbecue ranch.", 4.50, true)
                    )
                )
            )
        ),

        // 9. Golden Dragon Dim Sum
        Restaurant(
            id = "rest_109",
            name = "Golden Dragon Dim Sum",
            cuisines = listOf("Chinese", "Dim Sum", "Cantonese"),
            rating = 4.7f,
            totalRatingsCount = "4.4k+",
            priceRange = "$$",
            description = "Handcrafted bamboo-steamed dim sums, crispy Peking duck, and fragrant claypot rice specialties.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 2.8f,
            costForTwo = 30.0,
            offerText = "Flat 15% OFF on Steamed Baskets",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "18 Chinatown Promenade, Central",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_109_1",
                    name = "Dim Sum & Wok",
                    dishes = listOf(
                        Dish("d_109_1", "rest_109", "Steamed Shrimp Har Gow (4 Pcs)", "Translucent pleated dumplings filled with plump bamboo shrimp.", 7.50, false, isBestseller = true),
                        Dish("d_109_2", "rest_109", "Pork & Shrimp Siu Mai (4 Pcs)", "Open-topped steamed dumplings topped with orange flying fish roe.", 7.00, false),
                        Dish("d_109_3", "rest_109", "Barbecue Pork Char Siu Bao (3 Pcs)", "Fluffy white steamed buns filled with sweet caramelized barbecue pork.", 6.50, false),
                        Dish("d_109_4", "rest_109", "Crispy Peking Duck Pancakes", "Roasted duck breast with crispy skin, cucumber strips, scallions, and sweet bean sauce.", 21.00, false),
                        Dish("d_109_5", "rest_109", "Wok-Fried Cantonese Chow Mein", "Crispy egg noodles topped with sliced chicken, mushrooms, and tender bok choy in brown sauce.", 12.50, false),
                        Dish("d_109_6", "rest_109", "Egg Custard Dan Tat (2 Pcs)", "Flaky puff pastry tart filled with silky warm baked egg custard.", 5.00, true)
                    )
                )
            )
        ),

        // 10. Cedar Tree Shawarma
        Restaurant(
            id = "rest_110",
            name = "Cedar Tree Shawarma",
            cuisines = listOf("Middle Eastern", "Shawarma", "Falafel"),
            rating = 4.6f,
            totalRatingsCount = "3.9k+",
            priceRange = "$",
            description = "Rotisserie-carved spiced meats wrapped in fresh pita with creamy toum garlic sauce, tahini, and pickles.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 24,
            distanceKm = 1.4f,
            costForTwo = 15.0,
            offerText = "Free Hummus Dip with any 2 Wraps",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "24 Olive Branch Way, New Town",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_110_1",
                    name = "Wraps & Platters",
                    dishes = listOf(
                        Dish("d_110_1", "rest_110", "Classic Chicken Shawarma Wrap", "Spit-roasted sliced chicken wrapped in thin flatbread with garlic toum sauce and wild cucumber pickles.", 8.50, false, isBestseller = true),
                        Dish("d_110_2", "rest_110", "Beef & Lamb Shawarma Platter", "Seasoned carved beef and lamb served over turmeric spiced rice with hummus and fresh salad.", 13.99, false),
                        Dish("d_110_3", "rest_110", "Crispy Herb Falafel Plate (6 Pcs)", "Golden chickpea fritters blended with parsley and coriander, served with creamy tahini dip.", 7.50, true),
                        Dish("d_110_4", "rest_110", "Creamy Hummus with Warm Pita", "Velvety mashed chickpeas blended with tahini, lemon juice, and extra virgin olive oil.", 6.00, true),
                        Dish("d_110_5", "rest_110", "Fattoush Herb Salad", "Crisp romaine lettuce, radishes, cucumbers, and toasted pita crisps in tangy sumac dressing.", 6.50, true),
                        Dish("d_110_6", "rest_110", "Pistachio Honey Baklava (3 Pcs)", "Flaky layered phyllo pastry stuffed with crushed pistachios and orange blossom honey.", 5.00, true)
                    )
                )
            )
        ),

        // 11. Seoul Kitchen Korean BBQ
        Restaurant(
            id = "rest_111",
            name = "Seoul Kitchen Korean BBQ",
            cuisines = listOf("Korean", "Barbecue", "Bibimbap"),
            rating = 4.8f,
            totalRatingsCount = "3.5k+",
            priceRange = "$$",
            description = "Sizzling bulgogi beef, fermented kimchi stews, and crunchy twice-fried Korean sweet chili chicken.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 2.6f,
            costForTwo = 28.0,
            offerText = "20% OFF | Code SEOULBITE",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "52 K-Town Boulevard, North Park",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_111_1",
                    name = "Korean Classics",
                    dishes = listOf(
                        Dish("d_111_1", "rest_111", "Marinated Beef Bulgogi", "Thinly sliced tender ribeye marinated in sweet soy pear glaze, seared with scallions and sesame seeds.", 16.50, false, isBestseller = true),
                        Dish("d_111_2", "rest_111", "Yangnyeom Crispy Fried Chicken", "Double-fried chicken wings tossed in sticky sweet, spicy, and tangy gochujang glaze.", 12.00, false),
                        Dish("d_111_3", "rest_111", "Dolsot Bibimbap", "Steamed rice topped with seasoned namul vegetables, sliced beef, fried egg, and gochujang paste.", 13.50, false),
                        Dish("d_111_4", "rest_111", "Kimchi Jjigae Stew", "Comforting spicy stew with aged kimchi, pork belly, and soft tofu cubes, served with rice.", 11.50, false),
                        Dish("d_111_5", "rest_111", "Haemul Pajeon Seafood Pancake", "Crisp savory pancake packed with fresh scallions, squid, and shrimp, with soy vinegar dip.", 9.50, false),
                        Dish("d_111_6", "rest_111", "Japchae Sweet Potato Noodles", "Glass noodles stir-fried with wood ear mushrooms, spinach, bell peppers, and sesame oil.", 10.00, true)
                    )
                )
            )
        ),

        // 12. Le Bistro Parisien
        Restaurant(
            id = "rest_112",
            name = "Le Bistro Parisien",
            cuisines = listOf("French", "Steakhouse", "Pastry"),
            rating = 4.9f,
            totalRatingsCount = "2.1k+",
            priceRange = "$$$",
            description = "Classic French culinary refinement featuring steak frites, duck confit, and golden baked buttery croissants.",
            deliveryTimeMin = 35,
            deliveryTimeMax = 45,
            distanceKm = 4.2f,
            costForTwo = 50.0,
            offerText = "Complimentary Macarons with orders above $40",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "9 Eiffel Court, High Street",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_112_1",
                    name = "Bistro Classics",
                    dishes = listOf(
                        Dish("d_112_1", "rest_112", "Steak Frites au Poivre", "Prime pan-seared ribeye steak smothered in green peppercorn cognac cream with crisp pommes frites.", 26.00, false, isBestseller = true),
                        Dish("d_112_2", "rest_112", "Crispy Duck Confit", "Slow-cured duck leg roasted until golden and crispy, served with garlic herb potatoes.", 22.50, false),
                        Dish("d_112_3", "rest_112", "French Onion Soup Gratinée", "Rich caramelized beef broth with sourdough crouton and a thick melted Gruyère cheese crust.", 10.50, false),
                        Dish("d_112_4", "rest_112", "Ratatouille Provençale", "Baked spiral of thinly sliced zucchini, eggplant, and tomatoes over rich herb coulis.", 14.00, true),
                        Dish("d_112_5", "rest_112", "Crème Brûlée à la Vanille", "Creamy vanilla bean custard topped with a caramelized, crackling sugar shell.", 8.00, true),
                        Dish("d_112_6", "rest_112", "Assorted French Macarons (4 Pcs)", "Delicate almond meringue cookies filled with raspberry, pistachio, and chocolate ganache.", 7.50, true)
                    )
                )
            )
        ),

        // 13. Ocean Catch Seafood Shack
        Restaurant(
            id = "rest_113",
            name = "Ocean Catch Seafood Shack",
            cuisines = listOf("Seafood", "Fish & Chips", "Lobster Rolls"),
            rating = 4.7f,
            totalRatingsCount = "3.1k+",
            priceRange = "$$",
            description = "Wild-caught cod fish and chips, Maine lobster rolls, and steaming clam chowder bowls.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 30,
            distanceKm = 2.2f,
            costForTwo = 34.0,
            offerText = "$5 OFF on Fresh Catches",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "5 Wharfside Pier, Marina Bay",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_113_1",
                    name = "Seafood Favorites",
                    dishes = listOf(
                        Dish("d_113_1", "rest_113", "New England Lobster Roll", "Sweet chilled lobster meat lightly dressed with lemon herb mayo in a toasted buttered brioche split roll.", 22.00, false, isBestseller = true),
                        Dish("d_113_2", "rest_113", "Beer-Battered Atlantic Cod & Chips", "Flaky fresh cod dipped in ale batter, fried golden and served with tartar sauce and chips.", 15.50, false),
                        Dish("d_113_3", "rest_113", "Creamy Clam Chowder Bread Bowl", "Thick chowder with diced potatoes, tender clams, and smoked bacon in a sourdough bread bowl.", 11.00, false),
                        Dish("d_113_4", "rest_113", "Garlic Butter Grilled Prawns (6 Pcs)", "Jumbo tiger prawns seared on open flame with parsley garlic lemon butter.", 14.50, false),
                        Dish("d_113_5", "rest_113", "Crispy Popcorn Shrimp", "Bite-sized shrimp fried to golden crunch, served with sweet cocktail sauce.", 8.50, false),
                        Dish("d_113_6", "rest_113", "Old Bay Seasoned Fries", "Hand-cut french fries tossed in aromatic Maryland Old Bay spice mix.", 4.50, true)
                    )
                )
            )
        ),

        // 14. Pure Green Superfoods
        Restaurant(
            id = "rest_114",
            name = "Pure Green Superfoods",
            cuisines = listOf("Healthy", "Salads", "Smoothie Bowls"),
            rating = 4.8f,
            totalRatingsCount = "2.8k+",
            priceRange = "$$",
            description = "Nutrient-dense grain bowls, organic green salads, cold-pressed juices, and protein smoothies.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 22,
            distanceKm = 1.5f,
            costForTwo = 20.0,
            offerText = "15% OFF for Health Lovers",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "77 Wellness Way, Eco District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_114_1",
                    name = "Wholesome Bowls",
                    dishes = listOf(
                        Dish("d_114_1", "rest_114", "Avocado & Wild Salmon Grain Bowl", "Warm quinoa, grilled wild salmon, hass avocado, edamame, and sesame ginger dressing.", 15.50, false, isBestseller = true),
                        Dish("d_114_2", "rest_114", "Mediterranean Falafel Harvest", "Baked herb falafels, hummus, kalamata olives, cucumber, and creamy tahini dressing.", 12.00, true),
                        Dish("d_114_3", "rest_114", "Organic Acai Berry Bowl", "Pure Amazonian acai blended with banana, topped with chia seeds, granola, and fresh berries.", 9.50, true),
                        Dish("d_114_4", "rest_114", "Kale Caesar with Grilled Chicken", "Baby kale leaves, sourdough croutons, parmesan crisps, and greek yogurt caesar dressing.", 12.50, false),
                        Dish("d_114_5", "rest_114", "Cold-Pressed Green Glow Juice", "Fresh cold-pressed cucumber, celery, green apple, kale, ginger, and lemon.", 6.50, true),
                        Dish("d_114_6", "rest_114", "Raw Peanut Butter Energy Bites (3 Pcs)", "Rolled oats, organic peanut butter, chia seeds, and dark chocolate chips.", 4.50, true)
                    )
                )
            )
        ),

        // 15. Beirut Bites Mezza
        Restaurant(
            id = "rest_115",
            name = "Beirut Bites Mezza",
            cuisines = listOf("Lebanese", "Mediterranean", "Grill"),
            rating = 4.7f,
            totalRatingsCount = "3.0k+",
            priceRange = "$$",
            description = "Charcoal-grilled shish taouk, creamy baba ganoush, stuffed grape leaves, and warm freshly baked pita.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 32,
            distanceKm = 2.5f,
            costForTwo = 25.0,
            offerText = "Free Garlic Dip on every platter",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "60 Cedar Crest, Old Port",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_115_1",
                    name = "Lebanese Specialties",
                    dishes = listOf(
                        Dish("d_115_1", "rest_115", "Shish Taouk Skewer Platter", "Marinated garlic lemon chicken breast grilled over open charcoal, served with rice and garlic whip.", 14.50, false, isBestseller = true),
                        Dish("d_115_2", "rest_115", "Smoky Baba Ganoush", "Fire-roasted mashed eggplant mixed with tahini, garlic, and pomegranate seeds.", 7.00, true),
                        Dish("d_115_3", "rest_115", "Stuffed Grape Leaves (Warid Enab)", "Tender vine leaves rolled around fragrant herb rice and minced pine nuts.", 7.50, true),
                        Dish("d_115_4", "rest_115", "Kafta Mashwi Skewers", "Minced lamb and beef seasoned with onion, parsley, and sumac, charred to perfection.", 15.00, false),
                        Dish("d_115_5", "rest_115", "Traditional Tabbouleh", "Finely chopped parsley, mint, tomatoes, and bulgur dressed with olive oil and fresh lemon.", 6.50, true),
                        Dish("d_115_6", "rest_115", "Knafeh Pastry with Rose Water", "Warm shredded phyllo pastry filled with sweet cheese, soaked in rose syrup and crushed pistachios.", 6.50, true)
                    )
                )
            )
        ),

        // 16. Pho Saigon Express
        Restaurant(
            id = "rest_116",
            name = "Pho Saigon Express",
            cuisines = listOf("Vietnamese", "Pho", "Banh Mi"),
            rating = 4.8f,
            totalRatingsCount = "4.7k+",
            priceRange = "$",
            description = "Fragrant 24-hour beef bone pho soups, crispy banh mi baguettes, and fresh summer shrimp rolls.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 26,
            distanceKm = 1.8f,
            costForTwo = 18.0,
            offerText = "Flat $3 OFF on Pho Bowls",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "14 Lotus Lane, Southside",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_116_1",
                    name = "Pho & Banh Mi",
                    dishes = listOf(
                        Dish("d_116_1", "rest_116", "Pho Dac Biet (Special Beef Pho)", "Rice noodles in rich star-anise beef broth with rare steak slices, brisket, and beef meatballs.", 13.50, false, isBestseller = true),
                        Dish("d_116_2", "rest_116", "Crispy Pork Belly Banh Mi", "Warm French baguette filled with crispy roasted pork, liver pâté, pickled daikon, and cilantro.", 8.50, false),
                        Dish("d_116_3", "rest_116", "Fresh Shrimp Summer Rolls (3 Pcs)", "Translucent rice paper wrapping fresh shrimp, rice vermicelli, mint, and peanut dipping sauce.", 6.50, false),
                        Dish("d_116_4", "rest_116", "Bun Cha Hanoi Pork Vermicelli", "Grilled seasoned pork patties over cold vermicelli noodles, fresh herbs, and nuoc cham sauce.", 12.00, false),
                        Dish("d_116_5", "rest_116", "Crispy Imperial Egg Rolls (4 Pcs)", "Golden fried rolls filled with ground pork, wood ear mushrooms, and carrots.", 5.50, false),
                        Dish("d_116_6", "rest_116", "Vietnamese Iced Coffee (Ca Phe Sua Da)", "Slow-dripped dark roast coffee sweetened with condensed milk and poured over crushed ice.", 4.50, true)
                    )
                )
            )
        ),

        // 17. Southern Soul Kitchen
        Restaurant(
            id = "rest_117",
            name = "Southern Soul Kitchen",
            cuisines = listOf("American", "Soul Food", "Fried Chicken"),
            rating = 4.7f,
            totalRatingsCount = "3.6k+",
            priceRange = "$$",
            description = "Crispy golden fried chicken, slow-cooked collard greens, buttery cornbread, and honey butter biscuits.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 2.9f,
            costForTwo = 24.0,
            offerText = "Free Sweet Tea with Family Bucket",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "89 Magnolia Drive, Southern Gate",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_117_1",
                    name = "Southern Comforts",
                    dishes = listOf(
                        Dish("d_117_1", "rest_117", "Nashville Hot Fried Chicken (3 Pcs)", "Buttermilk-brined chicken deep fried to a crunch and brushed with spicy cayenne honey oil.", 13.99, false, isBestseller = true),
                        Dish("d_117_2", "rest_117", "Country Fried Steak & Gravy", "Crisp battered beef steak smothered in creamy black pepper country gravy.", 14.50, false),
                        Dish("d_117_3", "rest_117", "Slow-Braised Collard Greens", "Tender leafy greens simmered with smoked turkey bacon and cider vinegar.", 5.00, false),
                        Dish("d_117_4", "rest_117", "Creamy Pimento Mac & Cheese", "Cavatappi pasta baked with sharp pimento cheddar cheese.", 6.00, true),
                        Dish("d_117_5", "rest_117", "Honey Glazed Skillet Cornbread", "Sweet golden cornbread baked in a cast-iron skillet, brushed with whipped honey butter.", 4.50, true),
                        Dish("d_117_6", "rest_117", "Southern Pecan Pie Slice", "Classic buttery crust filled with rich brown sugar custard and roasted pecans.", 6.00, true)
                    )
                )
            )
        ),

        // 18. The Artisan Deli & Sandwich Co.
        Restaurant(
            id = "rest_118",
            name = "The Artisan Deli & Sandwich Co.",
            cuisines = listOf("Deli", "Sandwiches", "Bakery"),
            rating = 4.6f,
            totalRatingsCount = "4.2k+",
            priceRange = "$$",
            description = "Mile-high pastrami on rye, toasted sourdough paninis, and artisanal cured meats and cheeses.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 22,
            distanceKm = 1.1f,
            costForTwo = 19.0,
            offerText = "Combo: Sandwich + Chips + Drink for $14",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "22 Baker Street, Financial Hub",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_118_1",
                    name = "Handcrafted Sandwiches",
                    dishes = listOf(
                        Dish("d_118_1", "rest_118", "NYC Hot Pastrami on Rye", "Half-pound of hot steamed pastrami, spicy brown mustard, and Swiss cheese on marble rye.", 14.50, false, isBestseller = true),
                        Dish("d_118_2", "rest_118", "The Classic Reuben", "Corned beef, tangy sauerkraut, Russian dressing, and melted Swiss grilled on sourdough.", 13.50, false),
                        Dish("d_118_3", "rest_118", "Caprese Panini Supreme", "Fresh mozzarella, ripe tomatoes, basil pesto, and balsamic glaze pressed on focaccia.", 11.00, true),
                        Dish("d_118_4", "rest_118", "Roast Turkey & Avocado Club", "Smoked turkey breast, crispy bacon, avocado, lettuce, and mayo on toasted multigrain.", 12.00, false),
                        Dish("d_118_5", "rest_118", "Homemade Tomato Basil Bisque", "Smooth roasted tomato soup finished with heavy cream and fresh basil.", 5.50, true),
                        Dish("d_118_6", "rest_118", "Giant Sea Salt Chocolate Chunk Cookie", "Warm baked cookie loaded with dark Belgian chocolate chunks and Maldon sea salt flakes.", 3.50, true)
                    )
                )
            )
        ),

        // 19. Frosty Scoops & Gelato Bar
        Restaurant(
            id = "rest_119",
            name = "Frosty Scoops & Gelato Bar",
            cuisines = listOf("Desserts", "Ice Cream", "Gelato"),
            rating = 4.9f,
            totalRatingsCount = "5.3k+",
            priceRange = "$",
            description = "Slow-churned Italian gelato, decadent dessert sundaes, and warm Belgian waffle sandwiches.",
            deliveryTimeMin = 12,
            deliveryTimeMax = 20,
            distanceKm = 0.9f,
            costForTwo = 14.0,
            offerText = "Buy 2 Pints Get 1 Free",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "5 Sweet Alley, Arts District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_119_1",
                    name = "Gelato & Waffles",
                    dishes = listOf(
                        Dish("d_119_1", "rest_119", "Sicilian Pistachio Gelato Pint", "Authentic gelato made with 100% pure Bronte Sicilian pistachio paste.", 8.50, true, isBestseller = true),
                        Dish("d_119_2", "rest_119", "Dark Belgian Chocolate Ganache Pint", "Rich 70% dark chocolate churned into silky dense Italian gelato.", 8.00, true),
                        Dish("d_119_3", "rest_119", "Madagascar Vanilla Bean Pint", "Smooth cream infused with real speckled Madagascar vanilla pods.", 7.50, true),
                        Dish("d_119_4", "rest_119", "Warm Nutella Stuffed Waffle", "Freshly baked Belgian waffle stuffed with hazelnut spread and topped with powdered sugar.", 7.00, true),
                        Dish("d_119_5", "rest_119", "Brownie Fudge Lava Sundae", "Warm fudge brownie topped with two scoops of vanilla gelato and hot chocolate sauce.", 8.50, true),
                        Dish("d_119_6", "rest_119", "Alphonso Mango Sorbet Pint", "Dairy-free refreshing sorbet made from sweet ripe Alphonso mangoes.", 7.50, true)
                    )
                )
            )
        ),

        // 20. Santorini Greek Taverna
        Restaurant(
            id = "rest_120",
            name = "Santorini Greek Taverna",
            cuisines = listOf("Greek", "Mediterranean", "Gyros"),
            rating = 4.7f,
            totalRatingsCount = "2.9k+",
            priceRange = "$$",
            description = "Tender lamb gyros, flaky spanakopita, rich moussaka, and crisp Greek village salads.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 32,
            distanceKm = 2.3f,
            costForTwo = 26.0,
            offerText = "Free Tzatziki Dip on orders over $25",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "38 Aegean Way, Harbor Point",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_120_1",
                    name = "Greek Taverna Delights",
                    dishes = listOf(
                        Dish("d_120_1", "rest_120", "Classic Lamb & Beef Gyro Wrap", "Carved spiced meat wrapped in warm pita with tzatziki, tomatoes, red onions, and french fries.", 9.50, false, isBestseller = true),
                        Dish("d_120_2", "rest_120", "Baked Greek Moussaka", "Layers of spiced minced beef, roasted eggplant, and potatoes topped with golden béchamel sauce.", 15.50, false),
                        Dish("d_120_3", "rest_120", "Spanakopita Spinach Pie (2 Pcs)", "Flaky golden phyllo pastry triangles stuffed with spinach, feta cheese, and herbs.", 7.50, true),
                        Dish("d_120_4", "rest_120", "Souvlaki Chicken Skewer Platter", "Herb-marinated chicken skewers served with lemon oregano potatoes and warm pita.", 14.00, false),
                        Dish("d_120_5", "rest_120", "Horiatiki Village Greek Salad", "Vine tomatoes, crisp cucumbers, kalamata olives, and a slab of barrel-aged feta.", 8.50, true),
                        Dish("d_120_6", "rest_120", "Galaktoboureko Custard Pastry", "Semolina custard baked inside crispy golden phyllo pastry with spiced orange syrup.", 6.00, true)
                    )
                )
            )
        ),

        // 21. Barcelona Tapas & Paella
        Restaurant(
            id = "rest_121",
            name = "Barcelona Tapas & Paella",
            cuisines = listOf("Spanish", "Tapas", "Paella"),
            rating = 4.8f,
            totalRatingsCount = "3.3k+",
            priceRange = "$$$",
            description = "Saffron seafood paellas, sizzling garlic gambas al ajillo, and cured Jamón Ibérico tapas.",
            deliveryTimeMin = 30,
            deliveryTimeMax = 42,
            distanceKm = 3.4f,
            costForTwo = 42.0,
            offerText = "20% OFF on Traditional Paellas",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "7 Rambla Street, Cultural Quarter",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_121_1",
                    name = "Tapas & Paellas",
                    dishes = listOf(
                        Dish("d_121_1", "rest_121", "Paella de Marisco (Seafood Paella)", "Bomba rice cooked with saffron, calamari, mussels, clams, and tiger prawns.", 24.50, false, isBestseller = true),
                        Dish("d_121_2", "rest_121", "Gambas al Ajillo (Garlic Shrimp)", "Sizzling prawns cooked in olive oil with thinly sliced garlic and dried red chilies.", 12.00, false),
                        Dish("d_121_3", "rest_121", "Patatas Bravas with Spicy Aioli", "Crispy fried potato cubes drizzled with spicy smoked paprika tomato sauce and garlic aioli.", 7.50, true),
                        Dish("d_121_4", "rest_121", "Croquetas de Jamón (4 Pcs)", "Creamy béchamel croquettes loaded with cured Spanish ham and fried until golden.", 8.50, false),
                        Dish("d_121_5", "rest_121", "Tortilla Española Traditional", "Thick Spanish omelette baked with sliced potatoes and sweet caramelized onions.", 7.00, true),
                        Dish("d_121_6", "rest_121", "Crema Catalana Caramelized", "Zesty citrus and cinnamon infused custard topped with a brittle burnt sugar crust.", 6.50, true)
                    )
                )
            )
        ),

        // 22. Brooklyn Bagel & Bialy
        Restaurant(
            id = "rest_122",
            name = "Brooklyn Bagel & Bialy",
            cuisines = listOf("Breakfast", "Bagels", "Coffee"),
            rating = 4.6f,
            totalRatingsCount = "4.5k+",
            priceRange = "$",
            description = "Kettle-boiled New York bagels, whipped scallion cream cheeses, and Nova Scotia smoked lox.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 22,
            distanceKm = 1.2f,
            costForTwo = 14.0,
            offerText = "Free Fresh Drip Coffee with any Bagel",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "40 Flatbush Avenue, Downtown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_122_1",
                    name = "Bagel Sandwiches",
                    dishes = listOf(
                        Dish("d_122_1", "rest_122", "The Classic Nova Lox Bagel", "Everything bagel toasted with thick cream cheese, sliced smoked salmon, capers, and red onion.", 11.50, false, isBestseller = true),
                        Dish("d_122_2", "rest_122", "Bacon, Egg & Cheddar Brioche", "Crispy thick-cut bacon, scrambled eggs, and sharp cheddar on a toasted sesame bagel.", 7.50, false),
                        Dish("d_122_3", "rest_122", "Jalapeno Cheddar Bagel with Scallion Shmear", "Spicy baked bagel with whipped scallion cream cheese.", 5.00, true),
                        Dish("d_122_4", "rest_122", "Avocado & Everything Bagel", "Smashed avocado, lemon juice, chili flakes, and everything seasoning on multigrain bagel.", 7.00, true),
                        Dish("d_122_5", "rest_122", "Cold Brew Nitro Coffee", "Smooth, creamy nitrogen-infused cold brew coffee on draft.", 4.50, true),
                        Dish("d_122_6", "rest_122", "Chocolate Babka Slice", "Sweet twisted yeast bread with rich dark chocolate fudge ribbons.", 4.50, true)
                    )
                )
            )
        ),

        // 23. Little Italy Pizza Co.
        Restaurant(
            id = "rest_123",
            name = "Little Italy Pizza Co.",
            cuisines = listOf("Pizza", "Italian", "Calzones"),
            rating = 4.7f,
            totalRatingsCount = "6.1k+",
            priceRange = "$$",
            description = "Crispy thin-crust New York slices, loaded meat lover calzones, and garlic herb knots.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 30,
            distanceKm = 1.9f,
            costForTwo = 20.0,
            offerText = "Buy Large Pizza Get Free Garlic Knots",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "73 Mulberry Street, Central",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_123_1",
                    name = "Pizzas & Calzones",
                    dishes = listOf(
                        Dish("d_123_1", "rest_123", "Pepperoni Perfection 14\"", "Cup-and-char crispy pepperoni slices with whole milk mozzarella and seasoned tomato sauce.", 16.99, false, isBestseller = true),
                        Dish("d_123_2", "rest_123", "Four Cheese White Pizza", "Garlic infused ricotta, mozzarella, fontina, and parmesan with oregano.", 15.50, true),
                        Dish("d_123_3", "rest_123", "Meat Lovers Supreme", "Pepperoni, Italian fennel sausage, bacon, ham, and ground beef on rich tomato base.", 18.50, false),
                        Dish("d_123_4", "rest_123", "Stuffed Sausage & Ricotta Calzone", "Golden baked folded pizza dough filled with Italian sausage, mozzarella, and creamy ricotta.", 12.00, false),
                        Dish("d_123_5", "rest_123", "Garlic Knots Basket (6 Pcs)", "Fresh dough knots tossed in garlic butter, parmesan cheese, and parsley with marinara dip.", 5.50, true),
                        Dish("d_123_6", "rest_123", "Cannoli Siciliani (2 Pcs)", "Crispy fried pastry shells filled with sweet chocolate chip ricotta cream.", 5.50, true)
                    )
                )
            )
        ),

        // 24. Aloha Poke & Bowls
        Restaurant(
            id = "rest_124",
            name = "Aloha Poke & Bowls",
            cuisines = listOf("Hawaiian", "Poke", "Seafood"),
            rating = 4.8f,
            totalRatingsCount = "2.6k+",
            priceRange = "$$",
            description = "Fresh Hawaiian sushi-grade ahi tuna and salmon bowls customized with tropical fruits and spicy ponzu.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 25,
            distanceKm = 1.7f,
            costForTwo = 24.0,
            offerText = "10% OFF on Signature Bowls",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "12 Waikiki Bay, Oceanfront",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_124_1",
                    name = "Poke Bowls",
                    dishes = listOf(
                        Dish("d_124_1", "rest_124", "Classic Ahi Tuna Shoyu Bowl", "Fresh ahi tuna chunks tossed in sesame shoyu sauce, scallions, seaweed salad, and furikake over sushi rice.", 14.50, false, isBestseller = true),
                        Dish("d_124_2", "rest_124", "Spicy Salmon Crunch Bowl", "Atlantic salmon, spicy sriracha mayo, edamame, cucumber, masago, and crispy tempura flakes.", 14.00, false),
                        Dish("d_124_3", "rest_124", "Tofu & Avocado Teriyaki Bowl", "Organic braised tofu, creamy avocado slices, pickled ginger, and sweet teriyaki glaze.", 11.50, true),
                        Dish("d_124_4", "rest_124", "Hawaiian Kalua Pork Bowl", "Slow-roasted tender shredded kalua pork over white rice with macaroni salad.", 12.50, false),
                        Dish("d_124_5", "rest_124", "Sesame Seaweed Salad", "Chilled seasoned wakame seaweed with sesame seeds and rice vinegar.", 5.00, true),
                        Dish("d_124_6", "rest_124", "Pineapple Dole Whip Cup", "Refreshing frozen pineapple soft serve whip.", 4.50, true)
                    )
                )
            )
        ),

        // 25. Spice of Punjab
        Restaurant(
            id = "rest_125",
            name = "Spice of Punjab",
            cuisines = listOf("North Indian", "Curry", "Tandoori"),
            rating = 4.6f,
            totalRatingsCount = "5.1k+",
            priceRange = "$$",
            description = "Smoky tandoori chicken, creamy butter chicken, garlic naans, and rich Amritsari kulchas.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 30,
            distanceKm = 2.0f,
            costForTwo = 22.0,
            offerText = "Flat 40% OFF up to $6",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "90 Golden Temple Road, North Hub",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_125_1",
                    name = "Punjabi Feasts",
                    dishes = listOf(
                        Dish("d_125_1", "rest_125", "Butter Chicken Murgh Makhani", "Tandoori chicken pieces simmered in silky tomato, butter, and fenugreek gravy.", 13.99, false, isBestseller = true),
                        Dish("d_125_2", "rest_125", "Amritsari Chole Kulche", "Tangy chickpea curry served with two onion potato-stuffed tandoori kulchas.", 9.99, true),
                        Dish("d_125_3", "rest_125", "Paneer Tikka Masala", "Charcoal-grilled cottage cheese cubes cooked in spicy spiced onion tomato masala.", 12.50, true),
                        Dish("d_125_4", "rest_125", "Tandoori Half Chicken", "Bone-in chicken marinated in yogurt and crushed Kashmiri chilies, roasted in clay oven.", 11.50, false),
                        Dish("d_125_5", "rest_125", "Cheese Garlic Naan", "Tandoor baked bread stuffed with mozzarella cheese and coated in garlic butter.", 4.50, true),
                        Dish("d_125_6", "rest_125", "Pista Kulfi Falooda", "Rich frozen reduced milk ice cream on stick served with rose falooda noodles.", 5.00, true)
                    )
                )
            )
        )
    )
}
