package com.mk.ielts_speaking_practice.domain.model

import androidx.annotation.NonNull

data class CueCardModel(
    val title: String, val items: List<String>, val ending: String

) {
    override fun toString(): String {
        return "CueCardModel(title='$title', items=$items, ending='$ending')"
    }
}
