package com.linh.androiddeveloperchallenge.ratesvolume.presentation.utils

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Staff
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class PresentationUtilsKtTest {

    @Test
    fun getFullName() {
        val staff = Staff("Linh", "Nguyen")

        val expectedStaffFullNameDisplayText = "${staff.firstName} ${staff.lastName}"
        assertEquals(expectedStaffFullNameDisplayText, staff.getFullName())
    }

    @Test
    fun getFullNameWithEmptyLastNameStaff() {
        val staff = Staff("Linh", "")

        val expectedStaffFullNameDisplayText = staff.firstName
        assertEquals(expectedStaffFullNameDisplayText, staff.getFullName())
    }

    @Test
    fun getFullNameWithEmptyFirstNameStaff() {
        val staff = Staff("", "Nguyen")

        val expectedStaffFullNameDisplayText = staff.lastName
        assertEquals(expectedStaffFullNameDisplayText, staff.getFullName())
    }

    @Test
    fun getFullNameTrimmed() {
        val staff = Staff("    Linh    ", "   Nguyen   ")

        val expectedStaffFullNameDisplayText = "Linh Nguyen"
        assertEquals(expectedStaffFullNameDisplayText, staff.getFullName())
    }
}