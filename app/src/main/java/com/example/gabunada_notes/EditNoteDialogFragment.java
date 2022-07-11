package com.example.gabunada_notes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class EditNoteDialogFragment extends DialogFragment {
    EditNoteDialogListener listener;
    String note;

    public EditNoteDialogFragment(String note) {
        this.note = note;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (EditNoteDialogListener) context;
        } catch(ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " must implement EditNoteDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
    builder.setMessage("Edit " + note)
            .setView(inflater.inflate(R.layout.editdialog_layout,null))
                .setPositiveButton("EDIT", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface, int i){
                        listener.onEditListListenerMethod(EditNoteDialogFragment.this);
        }
    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            listener.onCanceltListenerMethod(EditNoteDialogFragment.this);
        }
    });
    return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        EditText etEdit = this.getDialog().findViewById(R.id.etEdit);
        etEdit.setText(note);
    }

    public interface EditNoteDialogListener{
        public void onEditListListenerMethod(DialogFragment dialog);
        public void onCanceltListenerMethod(DialogFragment dialog);
    }

}
