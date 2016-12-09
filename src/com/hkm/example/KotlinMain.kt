/**
 * Created by makhotin on 8/12/2016.
 */
package com.hkm.example

import com.hkm.example.JavaModel.JavaMultiMethodInterface

fun main(args: Array<String>) {
    println("hello")

    //================================
    //Basic Object declaration
    //================================
    val javaModel = JavaModel("java title", "java content", listOf())
    val kotlinModel = KotlinModel(content = "kotlin content", title = "kotlin title", tags = listOf()) //Named parameters


    //================================
    //Copy function
    //================================
    val javaModelCopy = JavaModel(javaModel.title, javaModel.content, javaModel.tags)
    val kotlinModelCopy = kotlinModel.copy()


    //================================
    //Default values
    //================================
    val javaTitle = javaModel.title ?: "No Title"
    val kotlinTitle = kotlinModel.title ?: "No Title"


    //================================
    // Logical Assignment
    //================================
    val javaContent: String =
            if (javaModel.title.isNullOrEmpty()) {
                ""
            } else {
                javaModel.content ?: ""
            }
    val kotlinContent: String =
            if (!kotlinModel.title.isNullOrEmpty()) {
                kotlinModel.content
            } else {
                null
            } ?: ""


    //================================
    // Interface and lambda
    //================================
    javaModel.setSingleListener { println(it) }
    javaModel.multiListener = object : JavaMultiMethodInterface {
        override fun doSomething(text: String?) {
            println(text)
        }

        override fun returnSomething(): String {
            return "something"
        }
    }

    KotlinModel(null, null, null,
            ::print,
            object : KotlinMultiMethodInterface {
                override fun doSomething(text: String) {
                    println(text)
                }

                override fun returnSomething(): String {
                    return "something"
                }
            })


    //================================
    // Map Reduce
    //================================
    val list = listOf(58,586,30,12,23)
    val sum: Int = list.filter { it%2==0 } //Filter even numbers only
            .map { it*10 }            //Times 10
            .reduce(Math::addExact)   //Sum them up




}

data class KotlinModel(val title: String?, val content: String?, val tags: List<String>?,
                       val singleListener: ((String) -> Unit)? = null, //Default value null
                       val multiListener: KotlinMultiMethodInterface? = null) //Default value null

interface KotlinMultiMethodInterface {
    fun doSomething(text: String)
    fun returnSomething(): String?
}