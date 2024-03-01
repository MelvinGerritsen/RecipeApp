package melvin.gerritsen.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(val idCategory:String,
    val strCategory: String,
    val strCategoryThumb:String,
    val strCategoryDescription:String):Parcelable

data class CategoriesResponse(val categories: List<Category>)

//        "strMeal": "Chick-Fil-A Sandwich",
//            "strMealThumb": "https://www.themealdb.com/images/media/meals/sbx7n71587673021.jpg",
//            "idMeal": "53016"