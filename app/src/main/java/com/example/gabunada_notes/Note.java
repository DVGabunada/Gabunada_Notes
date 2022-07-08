package com.example.gabunada_notes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Note {
     String note;
     Date created;

    public Note(String note) {
        this.note = note;
        created = new Date(System.currentTimeMillis());
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String timeString = sdf.format(created);
        return "Note{}";
    }
}
