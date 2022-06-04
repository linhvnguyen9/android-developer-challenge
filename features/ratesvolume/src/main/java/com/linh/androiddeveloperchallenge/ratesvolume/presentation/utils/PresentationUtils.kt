package com.linh.androiddeveloperchallenge.ratesvolume.presentation.utils

import com.linh.androiddeveloperchallenge.ratesvolume.domain.entity.Staff

fun Staff.getFullName() = listOf(firstName, lastName)
    .filter { it.isNotBlank() }
    .joinToString(separator = " ") { it.trim() }