package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.sample.SampleData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read app name string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Zomato", appName)
    }

    @Test
    fun `verify 50 fictional restaurants generated with complete menus`() {
        val restaurants = SampleData.restaurants
        assertEquals(50, restaurants.size)

        restaurants.forEach { restaurant ->
            assertTrue("Restaurant name should not be blank", restaurant.name.isNotBlank())
            assertTrue("Restaurant cuisine should not be empty", restaurant.cuisines.isNotEmpty())
            assertTrue("Rating should be between 1 and 5", restaurant.rating in 1.0f..5.0f)
            assertTrue("Price range should be valid", restaurant.priceRange in listOf("$", "$$", "$$$"))
            assertTrue("Description should not be blank", restaurant.description.isNotBlank())

            val allDishes = restaurant.menuCategories.flatMap { it.dishes }
            assertTrue(
                "Each restaurant must have between 5 and 10 dishes, found ${allDishes.size} for ${restaurant.name}",
                allDishes.size in 5..10
            )

            allDishes.forEach { dish ->
                assertTrue("Dish name should not be blank", dish.name.isNotBlank())
                assertTrue("Dish description should not be blank", dish.description.isNotBlank())
                assertTrue("Dish price should be positive", dish.price > 0.0)
            }
        }
    }
}
