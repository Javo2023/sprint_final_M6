package com.example.sprint_final_m6.data

import com.example.sprint_final_m6.data.remote.Telephone
import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun convertToEntity() {
        //given
        val telephone = Telephone(1, "name",234,"image")

        //when
        val result = telephone.convertToEntity()

        //then
        assertEquals(telephone.id,result.id)
        assertEquals(telephone.name,result.name)
        assertEquals(telephone.price,result.price)
        assertEquals(telephone.image,result.image)

    }
}