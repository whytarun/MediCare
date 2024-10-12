package com.medicare.auth.util

import com.medicare.database.model.Medicine

fun getDemoMedications(): List<Medicine> {
    return listOf(
        Medicine(1,"Aspirin", "100 mg", "500 mg"),
        Medicine(2,"SomethingElse", "50 mg", "500 mg"),
        Medicine(3,"Aspirin", "200 mg", "500 mg"),
        Medicine(4,"SomethingElse", "75 mg", "500 mg")
    )
}