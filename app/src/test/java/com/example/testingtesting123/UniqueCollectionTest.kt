package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun returnCorrectSize() {
        collection.addItem(Item("Passionfruit"))
        collection.addItem(Item("Strawberry"))

        assert (collection.size() == 2)
    }

    @Test
    fun removeItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        collection.remove(Item("item1"))

        assert (collection.size() == 1)
    }

    @Test
    fun removeTheRightItem() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        collection.remove(collection[1])

        assert (collection[0] == Item("item1"))
    }

}