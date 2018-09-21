package com.playground;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.playground.data.database.AppDatabase;
import com.playground.data.database.NoteEntry;
import com.playground.data.database.NoteEntryDao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by emil.ivanov on 9/21/18.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseInstrumentationTest {

    private NoteEntryDao noteEntryDao;
    private AppDatabase appDatabase;

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getTargetContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        noteEntryDao = appDatabase.noteDao();
    }

    @After
    public void release() {
        appDatabase.close();
    }


    @Test
    public void writeAndReadInList() {
        String noteTitle = "Title";
        NoteEntry noteEntry = new NoteEntry();
        noteEntry.setTitle(noteTitle);
        noteEntryDao.insertNote(noteEntry);
        NoteEntry searchNote = noteEntryDao.searchByTitle(noteTitle);
        assertThat(searchNote.getTitle(), equalTo(noteEntry.getTitle()));
    }
}
