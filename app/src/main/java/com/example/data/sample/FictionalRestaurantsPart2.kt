package com.example.data.sample

import com.example.R
import com.example.data.model.Dish
import com.example.data.model.MenuCategory
import com.example.data.model.Restaurant

object FictionalRestaurantsPart2 {

    val restaurants: List<Restaurant> = listOf(
        // 26. Chengdu Szechuan Hotpot
        Restaurant(
            id = "rest_126",
            name = "Chengdu Szechuan Hotpot",
            cuisines = listOf("Chinese", "Szechuan", "Hotpot"),
            rating = 4.8f,
            totalRatingsCount = "3.8k+",
            priceRange = "$$$",
            description = "Numbing Szechuan peppercorn broths, marbled beef slices, handcrafted meatballs, and fresh tofu skins.",
            deliveryTimeMin = 30,
            deliveryTimeMax = 42,
            distanceKm = 3.6f,
            costForTwo = 40.0,
            offerText = "20% OFF on Hotpot Combos",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "8 Fire Pepper Road, Chinatown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_126_1",
                    name = "Hotpot Delights",
                    dishes = listOf(
                        Dish("d_126_1", "rest_126", "Spicy Szechuan Mala Beef Broth Bowl", "Simmering spicy broth loaded with sliced prime beef, lotus roots, enoki mushrooms, and glass noodles.", 17.50, false, isBestseller = true),
                        Dish("d_126_2", "rest_126", "Mapo Tofu with Minced Pork", "Silken tofu simmered in fiery fermented bean chili oil, Sichuan peppercorns, and ground pork.", 12.00, false),
                        Dish("d_126_3", "rest_126", "Dan Dan Street Noodles", "Springy noodles coated in spicy sesame chili oil, ground pork, and preserved mustard greens.", 11.00, false),
                        Dish("d_126_4", "rest_126", "Crispy Szechuan Dry-Fried Green Beans", "Blistered green beans stir-fried with garlic, ginger, and dried chilies.", 9.50, true),
                        Dish("d_126_5", "rest_126", "Spicy Wontons in Red Chili Oil (6 Pcs)", "Pork dumplings swimming in aromatic garlic vinegar red oil sauce.", 8.00, false),
                        Dish("d_126_6", "rest_126", "Brown Sugar Sticky Rice Cakes", "Crispy fried glutinous rice cakes drizzled with molten brown sugar syrup.", 6.00, true)
                    )
                )
            )
        ),

        // 27. Istanbul Bosphorus Grill
        Restaurant(
            id = "rest_127",
            name = "Istanbul Bosphorus Grill",
            cuisines = listOf("Turkish", "Kebabs", "Pide"),
            rating = 4.7f,
            totalRatingsCount = "2.9k+",
            priceRange = "$$",
            description = "Charcoal-smoked Adana kebabs, boat-shaped Turkish pides, and slow-roasted spiced lamb shank.",
            deliveryTimeMin = 24,
            deliveryTimeMax = 34,
            distanceKm = 2.7f,
            costForTwo = 26.0,
            offerText = "Free Ayran with any Kebab Platter",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "19 Bosphorus Way, East Market",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_127_1",
                    name = "Turkish Specialties",
                    dishes = listOf(
                        Dish("d_127_1", "rest_127", "Adana Spicy Minced Lamb Kebab", "Hand-minced lamb skewered with red bell peppers, grilled over glowing charcoal, served with lavash.", 15.50, false, isBestseller = true),
                        Dish("d_127_2", "rest_127", "Sucuk & Kaşar Turkish Pide", "Boat-shaped baked flatbread topped with spicy Turkish beef pepperoni and melted sheep cheese.", 13.00, false),
                        Dish("d_127_3", "rest_127", "Iskender Kebab with Tomato Butter", "Thinly sliced lamb doner over pita cubes, drenched in hot tomato sauce and browned butter with yogurt.", 16.50, false),
                        Dish("d_127_4", "rest_127", "Meze Platter with Fresh Lavash", "Sampler of smoky haydari yogurt, spicy acılı ezme tomato dip, and stuffed grape leaves.", 9.50, true),
                        Dish("d_127_5", "rest_127", "Slow-Braised Lamb Shank with Rice", "Fall-off-the-bone lamb shank simmered with root vegetables over buttered orzo rice.", 21.00, false),
                        Dish("d_127_6", "rest_127", "Turkish Kunefe with Clotted Cream", "Crispy angel hair pastry soaked in sweet syrup with melted cheese center and kaymak.", 7.50, true)
                    )
                )
            )
        ),

        // 28. Havana Tropical Kitchen
        Restaurant(
            id = "rest_128",
            name = "Havana Tropical Kitchen",
            cuisines = listOf("Cuban", "Caribbean", "Sandwiches"),
            rating = 4.6f,
            totalRatingsCount = "2.4k+",
            priceRange = "$$",
            description = "Authentic pressed Cubano sandwiches, tender ropa vieja shredded beef, and sweet plantains.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 28,
            distanceKm = 2.0f,
            costForTwo = 22.0,
            offerText = "Free Fried Sweet Plantains on $20+",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "31 Palm Grove Boulevard, Coastal",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_128_1",
                    name = "Cuban Favorites",
                    dishes = listOf(
                        Dish("d_128_1", "rest_128", "The Original Pressed Cubano", "Slow-roasted mojo pork, sweet ham, Swiss cheese, dill pickles, and yellow mustard on pressed Cuban bread.", 12.50, false, isBestseller = true),
                        Dish("d_128_2", "rest_128", "Ropa Vieja Shredded Beef Platter", "Flank steak slow-cooked in sweet pepper tomato sauce, served with black beans and white rice.", 15.00, false),
                        Dish("d_128_3", "rest_128", "Crispy Mojo Chicken Thighs", "Citrus and garlic-marinated chicken seared with caramelized sweet onions.", 13.50, false),
                        Dish("d_128_4", "rest_128", "Maduros Sweet Fried Plantains", "Ripe golden plantains fried sweet and caramelized.", 4.50, true),
                        Dish("d_128_5", "rest_128", "Yuca Fries with Garlic Mojo Dip", "Cassava root wedges fried crispy, served with garlic lime dipping sauce.", 5.00, true),
                        Dish("d_128_6", "rest_128", "Flan de Caramelo Tradicional", "Rich silky baked egg custard topped with golden amber caramel sauce.", 5.50, true)
                    )
                )
            )
        ),

        // 29. Tuscany Woodfired Pasta Bar
        Restaurant(
            id = "rest_129",
            name = "Tuscany Woodfired Pasta Bar",
            cuisines = listOf("Italian", "Pasta", "Ravioli"),
            rating = 4.8f,
            totalRatingsCount = "3.7k+",
            priceRange = "$$$",
            description = "Artisanal hand-extruded pastas, rich slow-braised wild boar ragù, and creamy buffalo burrata.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 38,
            distanceKm = 3.1f,
            costForTwo = 44.0,
            offerText = "Complimentary Garlic Focaccia",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "55 Olive Hill Terrace, Upper Hills",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_129_1",
                    name = "Tuscan Pastas",
                    dishes = listOf(
                        Dish("d_129_1", "rest_129", "Pappardelle al Cinghiale", "Wide ribbon pasta tossed with slow-braised wild boar ragù, rosemary, and aged pecorino.", 19.50, false, isBestseller = true),
                        Dish("d_129_2", "rest_129", "Lobster & Ricotta Ravioli", "Handmade pasta pillows filled with sweet Maine lobster in creamy saffron tomato bisque.", 22.00, false),
                        Dish("d_129_3", "rest_129", "Whole Artisanal Burrata Pugliese", "Creamy burrata ball served with heirloom cherry tomatoes, basil pesto, and grilled sourdough.", 14.50, true),
                        Dish("d_129_4", "rest_129", "Gnocchi Quattro Formaggi", "Handcrafted potato dumplings baked in four-cheese cream with toasted walnuts.", 16.00, true),
                        Dish("d_129_5", "rest_129", "Rosemary Sea Salt Focaccia", "Warm olive oil flatbread topped with fresh rosemary sprigs and flaky sea salt.", 5.50, true),
                        Dish("d_129_6", "rest_129", "Flourless Chocolate Almond Torte", "Decadent dark chocolate torte with toasted almonds and espresso whipped cream.", 7.50, true)
                    )
                )
            )
        ),

        // 30. Maple & Bacon Brunch Club
        Restaurant(
            id = "rest_130",
            name = "Maple & Bacon Brunch Club",
            cuisines = listOf("Breakfast", "Pancakes", "Waffles"),
            rating = 4.7f,
            totalRatingsCount = "4.9k+",
            priceRange = "$$",
            description = "Fluffy Japanese souffle pancakes, avocado eggs benedict, and maple-glazed thick pork bacon.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 28,
            distanceKm = 1.9f,
            costForTwo = 24.0,
            offerText = "Buy Pancake Stack Get Free Orange Juice",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "77 Sunrise Promenade, North Side",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_130_1",
                    name = "Brunch Favorites",
                    dishes = listOf(
                        Dish("d_130_1", "rest_130", "Japanese Souffle Pancake Stack", "Three ultra-fluffy melt-in-your-mouth souffle pancakes served with pure Vermont maple syrup and butter.", 13.50, true, isBestseller = true),
                        Dish("d_130_2", "rest_130", "Smoked Salmon Eggs Benedict", "Toasted english muffin topped with poached eggs, smoked salmon, and silky hollandaise sauce.", 14.50, false),
                        Dish("d_130_3", "rest_130", "Brioche French Toast with Berries", "Thick-cut brioche soaked in vanilla egg custard, topped with berry compote and whipped cream.", 12.00, true),
                        Dish("d_130_4", "rest_130", "Avocado Toast with Crispy Bacon", "Sourdough toast with smashed avocado, poached farm egg, bacon, and chili crisp.", 11.50, false),
                        Dish("d_130_5", "rest_130", "Crispy Truffle Hash Brown Patties (2 Pcs)", "Golden grated potato patties fried crisp with white truffle oil and sea salt.", 5.50, true),
                        Dish("d_130_6", "rest_130", "Fresh Squeezed Valencia Orange Juice", "100% pure fresh cold-pressed orange juice.", 4.50, true)
                    )
                )
            )
        ),

        // 31. Oishii Ramen & Bao
        Restaurant(
            id = "rest_131",
            name = "Oishii Ramen & Bao",
            cuisines = listOf("Japanese", "Ramen", "Bao Buns"),
            rating = 4.6f,
            totalRatingsCount = "3.4k+",
            priceRange = "$$",
            description = "Fluffy steamed pork belly bao buns, spicy tantanmen ramen, and crispy gyoza dumplings.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 30,
            distanceKm = 2.1f,
            costForTwo = 24.0,
            offerText = "15% OFF on Bao & Ramen Combos",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "12 Neon Alley, Downtown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_131_1",
                    name = "Ramen & Baos",
                    dishes = listOf(
                        Dish("d_131_1", "rest_131", "Braised Pork Belly Bao Buns (2 Pcs)", "Steamed lotus leaf buns stuffed with melt-in-mouth pork belly, crushed peanuts, and hoisin sauce.", 8.50, false, isBestseller = true),
                        Dish("d_131_2", "rest_131", "Spicy Sesame Tantanmen Ramen", "Creamy sesame chili broth with seasoned ground pork, bok choy, and scallions.", 14.50, false),
                        Dish("d_131_3", "rest_131", "Crispy Panko Fried Chicken Bao (2 Pcs)", "Fried chicken tenders with spicy kimchi slaw and sweet chili mayo in steamed bao.", 8.50, false),
                        Dish("d_131_4", "rest_131", "Chicken Gyoza Dumplings (6 Pcs)", "Pan-fried Japanese dumplings served with ginger soy dipping sauce.", 7.00, false),
                        Dish("d_131_5", "rest_131", "Sea Salt Steamed Edamame", "Tender young soybean pods sprinkled with flaky sea salt.", 4.50, true),
                        Dish("d_131_6", "rest_131", "Matcha Mochi Ice Cream (3 Pcs)", "Sweet chewy rice dough encasing creamy green tea ice cream.", 5.50, true)
                    )
                )
            )
        ),

        // 32. Kingston Jerk & Rum BBQ
        Restaurant(
            id = "rest_132",
            name = "Kingston Jerk & Rum BBQ",
            cuisines = listOf("Caribbean", "Jerk Chicken", "Grill"),
            rating = 4.7f,
            totalRatingsCount = "2.8k+",
            priceRange = "$$",
            description = "Authentic Jamaican pimento-smoked jerk chicken, tender oxtail stew, and coconut rice and peas.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 3.2f,
            costForTwo = 26.0,
            offerText = "Free Fried Plantains on $25+",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "45 Reggae Ridge, South District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_132_1",
                    name = "Caribbean Specialties",
                    dishes = listOf(
                        Dish("d_132_1", "rest_132", "Authentic Jamaican Jerk Chicken", "Half chicken marinated in Scotch bonnet peppers, allspice, and thyme, grilled over pimento wood.", 14.50, false, isBestseller = true),
                        Dish("d_132_2", "rest_132", "Braised Caribbean Oxtail Stew", "Tender beef oxtails simmered in rich spiced butter bean gravy, served with rice and peas.", 18.00, false),
                        Dish("d_132_3", "rest_132", "Curry Goat Traditional", "Slow-cooked goat meat in aromatic West Indian yellow curry sauce.", 16.50, false),
                        Dish("d_132_4", "rest_132", "Traditional Rice & Peas", "Long grain rice cooked in rich coconut milk with red kidney beans and thyme.", 4.50, true),
                        Dish("d_132_5", "rest_132", "Golden Jamaican Beef Patty", "Flaky turmeric yellow pastry crust filled with spicy seasoned ground beef.", 4.00, false),
                        Dish("d_132_6", "rest_132", "Caribbean Rum Cake Slice", "Moist vanilla pound cake soaked in aged dark rum and brown sugar butter glaze.", 6.00, true)
                    )
                )
            )
        ),

        // 33. Prime Cut Steakhouse
        Restaurant(
            id = "rest_133",
            name = "Prime Cut Steakhouse",
            cuisines = listOf("Steakhouse", "American", "Fine Dining"),
            rating = 4.9f,
            totalRatingsCount = "2.2k+",
            priceRange = "$$$",
            description = "USDA Prime 35-day dry-aged steaks, jumbo lump crab cakes, and rich creamed spinach.",
            deliveryTimeMin = 35,
            deliveryTimeMax = 45,
            distanceKm = 4.5f,
            costForTwo = 65.0,
            offerText = "VIP Gold Free Delivery Included",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "1 Wall Street Plaza, Financial District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_133_1",
                    name = "Prime Steaks",
                    dishes = listOf(
                        Dish("d_133_1", "rest_133", "USDA Prime Ribeye (14 oz)", "Dry-aged 35 days, seared over cast iron with garlic herb compound butter.", 36.00, false, isBestseller = true),
                        Dish("d_133_2", "rest_133", "Filet Mignon (8 oz) with Red Wine Jus", "Ultra-tender center-cut tenderloin steak with bordelaise reduction sauce.", 34.00, false),
                        Dish("d_133_3", "rest_133", "Jumbo Lump Crab Cake", "Maryland blue crab cake with minimal filler, served with spicy remoulade.", 18.50, false),
                        Dish("d_133_4", "rest_133", "Truffle Parmesan Fries", "Hand-cut Idaho fries tossed with white truffle oil and freshly grated parmesan.", 8.00, true),
                        Dish("d_133_5", "rest_133", "Creamed Spinach with Nutmeg", "Tender baby spinach folded in velvety parmesan garlic cream with a hint of nutmeg.", 7.50, true),
                        Dish("d_133_6", "rest_133", "Molten Lava Chocolate Cake", "Warm chocolate cake with a molten fudge core, served with vanilla ice cream.", 9.00, true)
                    )
                )
            )
        ),

        // 34. Mumbai Street Express
        Restaurant(
            id = "rest_134",
            name = "Mumbai Street Express",
            cuisines = listOf("Indian", "Street Food", "Chaat"),
            rating = 4.6f,
            totalRatingsCount = "5.6k+",
            priceRange = "$",
            description = "Crispy spicy vada pav, buttery pav bhaji, tangy pani puri shots, and frankie rolls.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 22,
            distanceKm = 1.3f,
            costForTwo = 12.0,
            offerText = "Buy 2 Pav Bhaji Get Free Extra Pav",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "16 Marine Drive, Little Bombay",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_134_1",
                    name = "Mumbai Chaat & Street Eats",
                    dishes = listOf(
                        Dish("d_134_1", "rest_134", "Special Mumbai Butter Pav Bhaji", "Mashed spiced vegetable curry cooked on a giant flat tawa with abundant butter, served with two toasted pavs.", 7.99, true, isBestseller = true),
                        Dish("d_134_2", "rest_134", "Classic Vada Pav (Pack of 2)", "Spiced golden potato fritters tucked into soft buns with garlic red chili powder and green chutney.", 4.99, true),
                        Dish("d_134_3", "rest_134", "Crispy Pani Puri Box (8 Pcs)", "Hollow semolina puris filled with spiced potato-chickpeas and mint coriander spiced water.", 4.50, true),
                        Dish("d_134_4", "rest_134", "Paneer Tikka Frankie Wrap", "Warm flatbread rolled with marinated paneer, onions, and tangy chaat masala.", 5.99, true),
                        Dish("d_134_5", "rest_134", "Sev Puri Deluxe (6 Pcs)", "Flat crisp puris topped with potato, diced onion, sweet tamarind chutney, and a mountain of nylon sev.", 4.50, true),
                        Dish("d_134_6", "rest_134", "Mumbai Special Cutting Chai", "Strong aromatic black tea brewed with crushed ginger, cardamom, and milk.", 2.50, true)
                    )
                )
            )
        ),

        // 35. Acai & Granola Haven
        Restaurant(
            id = "rest_135",
            name = "Acai & Granola Haven",
            cuisines = listOf("Healthy", "Acai", "Smoothies"),
            rating = 4.8f,
            totalRatingsCount = "3.1k+",
            priceRange = "$$",
            description = "Thick blended organic acai smoothie bowls, artisanal toasted nut granolas, and superfood elixirs.",
            deliveryTimeMin = 14,
            deliveryTimeMax = 22,
            distanceKm = 1.2f,
            costForTwo = 18.0,
            offerText = "Free Extra Peanut Butter Drizzle",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "33 Sunshine Boulevard, Health District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_135_1",
                    name = "Acai & Smoothies",
                    dishes = listOf(
                        Dish("d_135_1", "rest_135", "Amazon Sunrise Acai Bowl", "Thick organic acai blend topped with strawberry slices, blueberries, coconut flakes, and honey drizzle.", 11.50, true, isBestseller = true),
                        Dish("d_135_2", "rest_135", "Nutty Cocoa Protein Bowl", "Acai blended with chocolate pea protein, topped with almond butter, hemp seeds, and cacao nibs.", 12.50, true),
                        Dish("d_135_3", "rest_135", "Dragonfruit Pitaya Glow Bowl", "Vibrant pink pitaya blended with mango and pineapple, topped with chia seeds and kiwi slices.", 11.00, true),
                        Dish("d_135_4", "rest_135", "Blue Spirulina Cloud Smoothie", "Coconut milk, banana, pineapple, and antioxidant-rich blue spirulina.", 7.50, true),
                        Dish("d_135_5", "rest_135", "Gluten-Free Almond Granola Cup", "Crunchy house-baked rolled oats with roasted almonds, cinnamon, and maple syrup.", 4.50, true),
                        Dish("d_135_6", "rest_135", "Matcha Coconut Iced Latte", "Ceremonial Japanese matcha whisked with oat milk and toasted coconut syrup.", 5.50, true)
                    )
                )
            )
        ),

        // 36. Donut Dreamland & Churros
        Restaurant(
            id = "rest_136",
            name = "Donut Dreamland & Churros",
            cuisines = listOf("Desserts", "Donuts", "Bakery"),
            rating = 4.7f,
            totalRatingsCount = "4.2k+",
            priceRange = "$",
            description = "Brioche sourdough donuts, filled custard bombolonis, and cinnamon churro loops with chocolate.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 24,
            distanceKm = 1.5f,
            costForTwo = 13.0,
            offerText = "Box of 6 for $15",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "8 Sugar Street, West Quarter",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_136_1",
                    name = "Handcrafted Donuts",
                    dishes = listOf(
                        Dish("d_136_1", "rest_136", "Creme Brulee Brioche Donut", "24-hour brioche dough filled with vanilla bean pastry cream, torched with crisp caramelized sugar glaze.", 4.50, true, isBestseller = true),
                        Dish("d_136_2", "rest_136", "Boston Cream Filled Donut", "Rich chocolate ganache frosted donut filled with velvety Bavarian cream.", 4.00, true),
                        Dish("d_136_3", "rest_136", "Nutella Hazelnut Bomboloni", "Sugar-dusted Italian donut stuffed with gooey hazelnut chocolate cream.", 4.50, true),
                        Dish("d_136_4", "rest_136", "Spanish Churros with Dulce de Leche", "Crispy ridged churros dusted in cinnamon sugar, served with warm dulce de leche dip.", 6.50, true),
                        Dish("d_136_5", "rest_136", "Strawberry Glazed Sprinkles", "Classic yeast donut with real strawberry puree glaze and rainbow sprinkles.", 3.50, true),
                        Dish("d_136_6", "rest_136", "Iced Vanilla Cold Foam Latte", "Espresso with milk, topped with sweet vanilla cream cold foam.", 4.50, true)
                    )
                )
            )
        ),

        // 37. Baja Coastal Fish Tacos
        Restaurant(
            id = "rest_137",
            name = "Baja Coastal Fish Tacos",
            cuisines = listOf("Mexican", "Seafood", "Tacos"),
            rating = 4.8f,
            totalRatingsCount = "3.7k+",
            priceRange = "$",
            description = "Crispy beer-battered wild cod tacos, spicy shrimp ceviche, and chipotle crema on warm corn tortillas.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 25,
            distanceKm = 1.8f,
            costForTwo = 19.0,
            offerText = "Taco Trio Combo with Mexican Coke for $13",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "9 Ocean Drive, Coastal Pier",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_137_1",
                    name = "Baja Tacos & Ceviche",
                    dishes = listOf(
                        Dish("d_137_1", "rest_137", "Crispy Baja Cod Fish Tacos (3 Pcs)", "Beer-battered cod fish in corn tortillas with shredded cabbage, pico de gallo, and chipotle crema.", 12.50, false, isBestseller = true),
                        Dish("d_137_2", "rest_137", "Blackened Gulf Shrimp Tacos (3 Pcs)", "Cajun seasoned shrimp with mango salsa and avocado lime sauce.", 13.50, false),
                        Dish("d_137_3", "rest_137", "Fresh Citrus Shrimp Ceviche", "Raw shrimp cured in fresh lime juice with cucumbers, red onions, tomatoes, and tortilla chips.", 10.50, false),
                        Dish("d_137_4", "rest_137", "Grilled Carne Asada Tacos (3 Pcs)", "Flank steak marinated in lime and cilantro, grilled over high heat with salsa verde.", 12.00, false),
                        Dish("d_137_5", "rest_137", "Street Corn (Elote en Vaso)", "Sweet corn off the cob mixed with cotija cheese, mayo, butter, and tajín chili powder.", 5.00, true),
                        Dish("d_137_6", "rest_137", "Mexican Glass Bottle Coca-Cola", "Classic cane sugar sweetened Coca-Cola.", 3.50, true)
                    )
                )
            )
        ),

        // 38. Dim Sum Palace
        Restaurant(
            id = "rest_138",
            name = "Dim Sum Palace",
            cuisines = listOf("Chinese", "Dim Sum", "Bao"),
            rating = 4.7f,
            totalRatingsCount = "4.0k+",
            priceRange = "$$",
            description = "Traditional cart-style steamed dumplings, pan-fried potstickers, and crispy sesame balls.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 32,
            distanceKm = 2.4f,
            costForTwo = 26.0,
            offerText = "15% OFF on Steamed Dumplings",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "51 Dragon Gate Street, Chinatown",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_138_1",
                    name = "Dim Sum Specialties",
                    dishes = listOf(
                        Dish("d_138_1", "rest_138", "Shanghai Soup Dumplings (Xiao Long Bao - 6 Pcs)", "Delicate wrappers filled with seasoned pork and rich piping hot savory broth.", 8.99, false, isBestseller = true),
                        Dish("d_138_2", "rest_138", "Pan-Fried Pork Potstickers (6 Pcs)", "Crispy bottomed dumplings filled with minced pork and scallions, served with black vinegar.", 7.50, false),
                        Dish("d_138_3", "rest_138", "Crispy Shrimp Spring Rolls (3 Pcs)", "Golden rolls filled with whole shrimp and bamboo shoots.", 6.50, false),
                        Dish("d_138_4", "rest_138", "Steamed Beef Meatballs with Bean Curd (3 Pcs)", "Tender spiced beef meatballs steamed over tofu skin with Worcestershire sauce.", 6.50, false),
                        Dish("d_138_5", "rest_138", "Stir-Fried Rice Rolls with XO Sauce", "Rolled rice noodle sheets wok-charred with dried scallop XO sauce and bean sprouts.", 8.50, false),
                        Dish("d_138_6", "rest_138", "Golden Sesame Red Bean Balls (3 Pcs)", "Crispy chewy glutinous rice balls coated in sesame seeds, filled with sweet red bean paste.", 5.00, true)
                    )
                )
            )
        ),

        // 39. Craft Patty Burger Lab
        Restaurant(
            id = "rest_139",
            name = "Craft Patty Burger Lab",
            cuisines = listOf("Burgers", "American", "Fries"),
            rating = 4.8f,
            totalRatingsCount = "5.1k+",
            priceRange = "$$",
            description = "Gourmet custom beef blends, molten truffle raclette cheese, and double-fried rosemary fries.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 28,
            distanceKm = 1.9f,
            costForTwo = 25.0,
            offerText = "Free Truffle Dip on orders over $20",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "27 Experiment Way, Science Park",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_139_1",
                    name = "Lab Crafted Burgers",
                    dishes = listOf(
                        Dish("d_139_1", "rest_139", "The Truffle Raclette Burger", "Custom dry-aged beef patty, melted raclette cheese, caramelized shallots, and black truffle mayo.", 13.50, false, isBestseller = true),
                        Dish("d_139_2", "rest_139", "Smoked Gouda & Onion Jam Burger", "Juicy Angus beef, smoked gouda melt, bourbon bacon onion jam, and arugula on brioche.", 12.99, false),
                        Dish("d_139_3", "rest_139", "Crispy Portobello Veggie Burger", "Panko-crusted portobello mushroom cap stuffed with fontina cheese, tomato, and basil aioli.", 11.50, true),
                        Dish("d_139_4", "rest_139", "Rosemary Garlic Duck Fat Fries", "Crispy hand-cut fries cooked in duck fat, tossed with fresh rosemary and sea salt.", 6.00, false),
                        Dish("d_139_5", "rest_139", "Crispy Fried Cheese Curds", "Wisconsin white cheddar cheese curds deep fried in tempura batter with jalapeño ranch.", 6.50, true),
                        Dish("d_139_6", "rest_139", "Bourbon Salted Caramel Milkshake", "Vanilla bean ice cream blended with caramel syrup, crushed toffee, and malt.", 6.00, true)
                    )
                )
            )
        ),

        // 40. Kerala Coastal Spice
        Restaurant(
            id = "rest_140",
            name = "Kerala Coastal Spice",
            cuisines = listOf("South Indian", "Seafood", "Kerala"),
            rating = 4.7f,
            totalRatingsCount = "3.3k+",
            priceRange = "$$",
            description = "Tangy coconut fish curries, flaky Malabar parottas, and tender slow-roasted beef fry.",
            deliveryTimeMin = 24,
            deliveryTimeMax = 34,
            distanceKm = 2.8f,
            costForTwo = 24.0,
            offerText = "20% OFF on Coastal Fish Meals",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "44 Backwater Way, South Quarter",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_140_1",
                    name = "Kerala Coastal Curries",
                    dishes = listOf(
                        Dish("d_140_1", "rest_140", "Alleppey Fish Curry with Kudampuli", "Kingfish steak simmered in raw mango, coconut milk, and kokum tamarind gravy.", 14.99, false, isBestseller = true),
                        Dish("d_140_2", "rest_140", "Kerala Beef Roast with Coconut Chips", "Tender beef chunks slow-roasted with black pepper, crushed ginger, and crispy coconut slices.", 13.50, false),
                        Dish("d_140_3", "rest_140", "Flaky Malabar Parotta (Pack of 2)", "Layered spiral flatbread cooked on tawa with ghee until flaky and golden.", 3.50, true),
                        Dish("d_140_4", "rest_140", "Prawns Pepper Roast", "Tiger prawns wok-roasted with crushed shallots, curry leaves, and fresh black pepper.", 15.00, false),
                        Dish("d_140_5", "rest_140", "Crispy Vegetable Appam (2 Pcs)", "Lacy fermented rice batter hoppers with a soft fluffy sponge center.", 3.50, true),
                        Dish("d_140_6", "rest_140", "Payasam Rice Kheer with Cashews", "Sweet dessert made with milk, cardamom, roasted vermicelli, and fried cashews.", 4.50, true)
                    )
                )
            )
        ),

        // 41. The Rusty Tap Gastropub
        Restaurant(
            id = "rest_141",
            name = "The Rusty Tap Gastropub",
            cuisines = listOf("Gastropub", "American", "Wings"),
            rating = 4.6f,
            totalRatingsCount = "3.5k+",
            priceRange = "$$",
            description = "Crispy jumbo chicken wings, loaded pretzel bites with craft beer cheese, and short rib poutine.",
            deliveryTimeMin = 22,
            deliveryTimeMax = 32,
            distanceKm = 2.3f,
            costForTwo = 28.0,
            offerText = "Free Side of Fries on orders over $25",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "17 Brewery Lane, Industrial District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_141_1",
                    name = "Pub Fare",
                    dishes = listOf(
                        Dish("d_141_1", "rest_141", "Braised Short Rib Poutine", "Crispy fries topped with Wisconsin cheese curds, slow-cooked short rib shreds, and rich beef gravy.", 13.50, false, isBestseller = true),
                        Dish("d_141_2", "rest_141", "Jumbo Buffalo Wings (8 Pcs)", "Crisp double-fried chicken wings tossed in tangy cayenne pepper buffalo sauce with blue cheese dip.", 12.00, false),
                        Dish("d_141_3", "rest_141", "Warm Soft Pretzel Bites", "Bavarian pretzel bites served with warm amber ale cheddar cheese fondue.", 7.50, true),
                        Dish("d_141_4", "rest_141", "Fish and Chips Basket", "Crispy ale-battered haddock filet with fries and house tartar sauce.", 14.50, false),
                        Dish("d_141_5", "rest_141", "Smoked Brisket Quesadilla", "Flour tortilla with melted Monterey Jack, smoked brisket, and charred corn.", 11.00, false),
                        Dish("d_141_6", "rest_141", "Warm Skillet Salted Caramel Brownie", "Fudge brownie with vanilla ice cream and pretzel crumbles.", 7.00, true)
                    )
                )
            )
        ),

        // 42. Creperie de Paris
        Restaurant(
            id = "rest_142",
            name = "Creperie de Paris",
            cuisines = listOf("French", "Crepes", "Desserts"),
            rating = 4.8f,
            totalRatingsCount = "2.9k+",
            priceRange = "$$",
            description = "Crispy buckwheat galettes, sweet dessert crepes, and melted Emmental cheese delicacies.",
            deliveryTimeMin = 18,
            deliveryTimeMax = 28,
            distanceKm = 1.9f,
            costForTwo = 22.0,
            offerText = "10% OFF on Sweet & Savory Pairs",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "21 Montmartre Court, Old Town",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_142_1",
                    name = "French Crepes & Galettes",
                    dishes = listOf(
                        Dish("d_142_1", "rest_142", "Galette Complète Traditonnelle", "Gluten-free buckwheat crepe filled with French ham, melted Emmental cheese, and sunny-side egg.", 12.50, false, isBestseller = true),
                        Dish("d_142_2", "rest_142", "Crepe Suzette au Caramel", "Sweet crepe with caramelized orange sugar butter sauce and candied orange zest.", 9.50, true),
                        Dish("d_142_3", "rest_142", "Smoked Salmon & Dill Crepe", "Savory crepe with smoked Norwegian salmon, cream cheese, and fresh dill.", 13.50, false),
                        Dish("d_142_4", "rest_142", "Nutella Banana & Toasted Almond Crepe", "Warm crepe generously spread with Nutella, fresh banana slices, and toasted sliced almonds.", 8.50, true),
                        Dish("d_142_5", "rest_142", "Goat Cheese & Honey Galette", "Creamy goat cheese, walnuts, and wild lavender honey folded in buckwheat galette.", 11.00, true),
                        Dish("d_142_6", "rest_142", "French Dark Roast Café au Lait", "Freshly brewed dark roast coffee with steamed whole milk foam.", 4.00, true)
                    )
                )
            )
        ),

        // 43. Nordic Salmon & Smorgasbord
        Restaurant(
            id = "rest_143",
            name = "Nordic Salmon & Smorgasbord",
            cuisines = listOf("Scandinavian", "Seafood", "Deli"),
            rating = 4.9f,
            totalRatingsCount = "1.8k+",
            priceRange = "$$$",
            description = "Cured gravlax salmon on rye, Swedish meatballs with lingonberry jam, and roasted root vegetable hash.",
            deliveryTimeMin = 28,
            deliveryTimeMax = 38,
            distanceKm = 3.5f,
            costForTwo = 46.0,
            offerText = "Complimentary Lingonberry Tart on $40+",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "6 Fjord Avenue, Marina Promenade",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_143_1",
                    name = "Nordic Delicacies",
                    dishes = listOf(
                        Dish("d_143_1", "rest_143", "Dill Cured Gravlax on Dark Rye", "House-cured Norwegian salmon slices with sweet mustard dill sauce on seeded dark rye.", 16.50, false, isBestseller = true),
                        Dish("d_143_2", "rest_143", "Swedish Meatballs (Köttbullar)", "Pork and beef meatballs in rich creamy brown gravy with potato puree and wild lingonberry preserve.", 17.00, false),
                        Dish("d_143_3", "rest_143", "Smoked Rainbow Trout Toast", "Flaked smoked trout, pickled radishes, and horseradish cream on toasted sourdough.", 14.50, false),
                        Dish("d_143_4", "rest_143", "Herbed Roasted Beetroot Salad", "Golden and red roasted beets with goat cheese and toasted caraway seeds.", 9.50, true),
                        Dish("d_143_5", "rest_143", "Creamy Potato & Leek Soup", "Velvety smooth potato soup with leeks and chive oil drizzle.", 7.50, true),
                        Dish("d_143_6", "rest_143", "Cardamom Cinnamon Bun (Kardemummabulle)", "Twisted Swedish sweet pastry dough flavored with crushed green cardamom seeds.", 4.50, true)
                    )
                )
            )
        ),

        // 44. Isfahan Persian Saffron Grill
        Restaurant(
            id = "rest_144",
            name = "Isfahan Persian Saffron Grill",
            cuisines = listOf("Persian", "Middle Eastern", "Kebabs"),
            rating = 4.8f,
            totalRatingsCount = "2.7k+",
            priceRange = "$$",
            description = "Fragrant saffron barberry rice, succulent koobideh skewers, and slow-braised pomegranate walnut stews.",
            deliveryTimeMin = 25,
            deliveryTimeMax = 35,
            distanceKm = 2.9f,
            costForTwo = 32.0,
            offerText = "20% OFF on Persian Mixed Grills",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "82 Shiraz Crescent, Old Quarter",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_144_1",
                    name = "Persian Grill & Stews",
                    dishes = listOf(
                        Dish("d_144_1", "rest_144", "Kabab Koobideh Skewers (2 Pcs)", "Charcoal-grilled minced lamb and beef seasoned with grated onion and saffron, served with saffron rice.", 15.50, false, isBestseller = true),
                        Dish("d_144_2", "rest_144", "Joojeh Saffron Chicken Kabab", "Bone-in chicken marinated in saffron, onion juice, and lemon juice, grilled on skewers.", 14.50, false),
                        Dish("d_144_3", "rest_144", "Fesenjan Walnut Pomegranate Stew", "Chicken simmered in rich sweet and tart ground walnut and pomegranate molasses sauce.", 16.00, false),
                        Dish("d_144_4", "rest_144", "Ghormeh Sabzi Herb Stew", "Fragrant slow-cooked herb stew with lamb cubes, kidney beans, and dried limes.", 15.00, false),
                        Dish("d_144_5", "rest_144", "Zereshk Polo (Barberry Saffron Rice)", "Fluffy basmati rice topped with tart ruby red barberries sauteed in butter and saffron.", 5.00, true),
                        Dish("d_144_6", "rest_144", "Persian Saffron Rosewater Ice Cream (Bastani)", "Traditional yellow saffron ice cream with pistachio chunks and frozen clotted cream.", 5.50, true)
                    )
                )
            )
        ),

        // 45. Singapore Hawker Express
        Restaurant(
            id = "rest_145",
            name = "Singapore Hawker Express",
            cuisines = listOf("Singaporean", "Noodles", "Asian"),
            rating = 4.7f,
            totalRatingsCount = "4.6k+",
            priceRange = "$$",
            description = "Spicy coconut curry laksa, fragrant Hainanese chicken rice, and smoky wok-charred char kway teow.",
            deliveryTimeMin = 20,
            deliveryTimeMax = 30,
            distanceKm = 2.2f,
            costForTwo = 22.0,
            offerText = "Flat $4 OFF on orders over $18",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "38 Merlion Boulevard, Asian Market",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_145_1",
                    name = "Hawker Favorites",
                    dishes = listOf(
                        Dish("d_145_1", "rest_145", "Singapore Katong Laksa", "Thick rice vermicelli in spicy coconut curry broth with prawns, fish cake, tofu puffs, and laksa leaves.", 13.99, false, isBestseller = true),
                        Dish("d_145_2", "rest_145", "Hainanese Poached Chicken Rice", "Tender poached chicken served over chicken-broth cooked jasmine rice with ginger chili sauce.", 12.50, false),
                        Dish("d_145_3", "rest_145", "Char Kway Teow Smoky Noodles", "Flat rice noodles wok-fried with sweet soy sauce, Chinese sausage, shrimp, eggs, and bean sprouts.", 12.00, false),
                        Dish("d_145_4", "rest_145", "Chicken Satay Skewers (5 Pcs)", "Grilled skewered chicken served with sweet spiced peanut sauce and cucumber chunks.", 8.00, false),
                        Dish("d_145_5", "rest_145", "Roti Prata with Curry Dip (2 Pcs)", "Crispy flipped flatbread served with savory lentil dhal curry dip.", 5.00, true),
                        Dish("d_145_6", "rest_145", "Chendol Shaved Ice Dessert", "Shaved ice with coconut milk, green pandan jelly noodles, red beans, and palm sugar syrup.", 5.50, true)
                    )
                )
            )
        ),

        // 46. Hot Cluckers Fried Chicken
        Restaurant(
            id = "rest_146",
            name = "Hot Cluckers Fried Chicken",
            cuisines = listOf("American", "Fast Food", "Chicken"),
            rating = 4.6f,
            totalRatingsCount = "6.2k+",
            priceRange = "$",
            description = "Jumbo crispy chicken tenders, Nashville cayenne spice shakes, and buttermilk waffle combos.",
            deliveryTimeMin = 14,
            deliveryTimeMax = 22,
            distanceKm = 1.1f,
            costForTwo = 16.0,
            offerText = "Free Dipping Sauce Trio",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "95 Rooster Way, College Town",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_146_1",
                    name = "Chicken Tenders & Sandwiches",
                    dishes = listOf(
                        Dish("d_146_1", "rest_146", "Crispy Jumbo Tender Combo (4 Pcs)", "Extra-large hand-breaded chicken tenders with crinkle cut fries and two cluck sauces.", 11.50, false, isBestseller = true),
                        Dish("d_146_2", "rest_146", "The Blazing Clucker Sandwich", "Fried chicken breast dusted in ghost pepper spice with dill pickles and comeback sauce on brioche.", 9.99, false),
                        Dish("d_146_3", "rest_146", "Chicken and Belgian Waffle", "Two crispy fried chicken thighs served over golden Belgian waffle with warm maple butter.", 12.50, false),
                        Dish("d_146_4", "rest_146", "Loaded Crinkle Cut Cheese Fries", "Crinkle fries smothered in warm cheddar cheese sauce, bacon crumbles, and green onions.", 5.50, false),
                        Dish("d_146_5", "rest_146", "Crispy Fried Mac & Cheese Bites (4 Pcs)", "Bite-sized cheddar macaroni rolled in seasoned breadcrumbs and deep fried.", 5.00, true),
                        Dish("d_146_6", "rest_146", "Fresh Lemonade Cooler", "Hand-squeezed sweet tart lemonade over crushed ice.", 3.50, true)
                    )
                )
            )
        ),

        // 47. Farm-to-Table Harvest Kitchen
        Restaurant(
            id = "rest_147",
            name = "Farm-to-Table Harvest Kitchen",
            cuisines = listOf("Organic", "Healthy", "American"),
            rating = 4.9f,
            totalRatingsCount = "2.5k+",
            priceRange = "$$$",
            description = "Locally sourced seasonal vegetables, pasture-raised roast chicken, and fresh stoneground sourdough.",
            deliveryTimeMin = 30,
            deliveryTimeMax = 40,
            distanceKm = 3.8f,
            costForTwo = 48.0,
            offerText = "Complimentary Seed Bread Loaf",
            bannerDrawableRes = R.drawable.img_dining_hero,
            address = "12 Meadow Lane, Green Belt",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_147_1",
                    name = "Seasonal Harvest",
                    dishes = listOf(
                        Dish("d_147_1", "rest_147", "Pasture-Raised Half Roast Chicken", "Slow-roasted chicken with fresh thyme, served over roasted rainbow carrots and pan jus.", 23.00, false, isBestseller = true),
                        Dish("d_147_2", "rest_147", "Wild Mushroom & Farro Risotto", "Nutty farro grain cooked with foraged chanterelle mushrooms, white wine, and parmesan.", 18.50, true),
                        Dish("d_147_3", "rest_147", "Heirloom Tomato & Grilled Peach Salad", "Ripe heirloom tomatoes, charred sweet peaches, burrata, and aged white balsamic glaze.", 13.50, true),
                        Dish("d_147_4", "rest_147", "Crispy Brussels Sprouts with Apple Cider Glaze", "Flash-fried brussels sprouts tossed with cider reduction and toasted pecans.", 8.50, true),
                        Dish("d_147_5", "rest_147", "Roasted Butternut Squash Soup", "Creamy velouté of roasted squash finished with toasted pumpkin seeds and sage brown butter.", 8.00, true),
                        Dish("d_147_6", "rest_147", "Honey Glazed Warm Fig Tart", "Almond cream tart filled with fresh black mission figs and honey drizzle.", 8.50, true)
                    )
                )
            )
        ),

        // 48. Brussels Waffle & Chocolate Studio
        Restaurant(
            id = "rest_148",
            name = "Brussels Waffle & Chocolate Studio",
            cuisines = listOf("Desserts", "Waffles", "Bakery"),
            rating = 4.8f,
            totalRatingsCount = "3.9k+",
            priceRange = "$$",
            description = "Caramelized pearl sugar Liege waffles, rich fondue dipping cups, and handcrafted pralines.",
            deliveryTimeMin = 15,
            deliveryTimeMax = 25,
            distanceKm = 1.4f,
            costForTwo = 18.0,
            offerText = "Buy 2 Waffles Get Free Hot Chocolate",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "66 Grand Place, Central Square",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_148_1",
                    name = "Belgian Waffles & Chocolate",
                    dishes = listOf(
                        Dish("d_148_1", "rest_148", "Authentic Liege Waffle with Strawberries", "Dense dough waffle with molten caramelized pearl sugar pockets, fresh strawberries, and whipped cream.", 8.50, true, isBestseller = true),
                        Dish("d_148_2", "rest_148", "Dark Chocolate Fondue Waffle Box", "Warm waffle bites served with warm Belgian dark chocolate dipping pot.", 9.50, true),
                        Dish("d_148_3", "rest_148", "Speculoos Cookie Butter Crunch Waffle", "Waffle smothered in Biscoff speculoos spread, crushed cookie crumbles, and vanilla cream.", 8.50, true),
                        Dish("d_148_4", "rest_148", "Artisanal Belgian Truffles Box (4 Pcs)", "Dark chocolate ganache rolled in cocoa powder, roasted hazelnut, and raspberry dust.", 7.50, true),
                        Dish("d_148_5", "rest_148", "Thick Belgian Hot Chocolate", "Real melted Belgian chocolate stirred with hot whole milk and topped with marshmallow cream.", 5.00, true),
                        Dish("d_148_6", "rest_148", "Double Chocolate Chip Cookie", "Fudgy cookie baked with milk and dark chocolate chips.", 3.50, true)
                    )
                )
            )
        ),

        // 49. The Smashhouse Tap & Grill
        Restaurant(
            id = "rest_149",
            name = "The Smashhouse Tap & Grill",
            cuisines = listOf("Burgers", "American", "Pub"),
            rating = 4.7f,
            totalRatingsCount = "4.3k+",
            priceRange = "$$",
            description = "Ultra-crispy edged smash burgers, cheddar bacon loaded tots, and craft root beer floats.",
            deliveryTimeMin = 16,
            deliveryTimeMax = 24,
            distanceKm = 1.6f,
            costForTwo = 20.0,
            offerText = "$3 OFF on Double Burger Combos",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "59 Foundry Street, Eastside",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_149_1",
                    name = "Smashhouse Favorites",
                    dishes = listOf(
                        Dish("d_149_1", "rest_149", "The Triple Oklahoma Onion Smash", "Three beef patties smashed with shaved yellow onions, triple American cheese, and house sauce.", 12.50, false, isBestseller = true),
                        Dish("d_149_2", "rest_149", "Bacon Jam Blue Cheese Smash", "Double smash patties with melted blue cheese crumbles, caramelized bacon jam, and baby arugula.", 12.00, false),
                        Dish("d_149_3", "rest_149", "Spicy Jalapeno Pepper Jack Burger", "Seared patties, pepper jack cheese, pickled jalapeños, and smoky chipotle aioli.", 11.50, false),
                        Dish("d_149_4", "rest_149", "Loaded Crispy Tater Tots", "Extra crispy tater tots smothered with cheddar cheese, bacon bits, and sour cream.", 6.00, false),
                        Dish("d_149_5", "rest_149", "Crispy Mozzarella Sticks (5 Pcs)", "Golden breaded mozzarella cheese sticks with warm marinara dipping sauce.", 6.00, true),
                        Dish("d_149_6", "rest_149", "Old Fashioned Draft Root Beer Float", "Handcrafted root beer poured over two scoops of creamy vanilla bean ice cream.", 5.00, true)
                    )
                )
            )
        ),

        // 50. Taqueria Los Compadres
        Restaurant(
            id = "rest_150",
            name = "Taqueria Los Compadres",
            cuisines = listOf("Mexican", "Tacos", "Street Food"),
            rating = 4.8f,
            totalRatingsCount = "5.9k+",
            priceRange = "$",
            description = "Charred carne asada tacos, melted queso fundido with chorizo, and ice-cold sweet cinnamon horchata.",
            deliveryTimeMin = 14,
            deliveryTimeMax = 22,
            distanceKm = 1.0f,
            costForTwo = 15.0,
            offerText = "4 Tacos + Chips & Salsa for $12",
            bannerDrawableRes = R.drawable.img_hero_banner,
            address = "3 Mission Plaza, West District",
            menuCategories = listOf(
                MenuCategory(
                    id = "c_150_1",
                    name = "Taqueria Staples",
                    dishes = listOf(
                        Dish("d_150_1", "rest_150", "Carne Asada Street Tacos (4 Pcs)", "Flame-grilled citrus flank steak on mini corn tortillas with diced onions, cilantro, and roasted salsa.", 11.00, false, isBestseller = true),
                        Dish("d_150_2", "rest_150", "Crispy Carnitas Tacos (4 Pcs)", "Slow-simmered pork shoulder crisped in its own juices with pickled jalapeños and salsa verde.", 10.50, false),
                        Dish("d_150_3", "rest_150", "Queso Fundido with Mexican Chorizo", "Melted Oaxaca and Monterey Jack cheeses bubbling with spicy chorizo, served with warm tortillas.", 8.50, false),
                        Dish("d_150_4", "rest_150", "Fresh Guacamole & Tortilla Chips", "Hand-mashed hass avocados with lime juice, cilantro, jalapeño, and crispy corn chips.", 6.50, true),
                        Dish("d_150_5", "rest_150", "Cheesy Bean & Rice Burrito", "Refried pinto beans, Mexican rice, melted cheese, and salsa fresca wrapped in a warm flour tortilla.", 7.50, true),
                        Dish("d_150_6", "rest_150", "Sweet Cinnamon Rice Horchata", "Refreshing chilled rice milk flavored with cinnamon and Mexican vanilla.", 3.50, true)
                    )
                )
            )
        )
    )
}
