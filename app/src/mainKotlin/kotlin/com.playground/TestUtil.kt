package com.playground

import com.playground.entities.NoteEntry
import java.sql.Date

/**
 * Created by emil.ivanov on 9/21/18.
 */
fun createNote(): NoteEntry {
    return NoteEntry(0, "", "", 0, Date.valueOf(System.currentTimeMillis().toString()))
}
