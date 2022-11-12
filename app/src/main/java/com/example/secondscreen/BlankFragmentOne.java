package com.example.secondscreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentOne extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentOne newInstance(String param1, String param2) {
        BlankFragmentOne fragment = new BlankFragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_one, container, false);
        Button button = view.findViewById(R.id.buttonFrag);
        TextView textView = view.findViewById(R.id.textViewThree);
        TextView textViewSec = view.findViewById(R.id.textViewFour);

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){

            String str = textView.getText().toString();
            String secStr =textViewSec.getText().toString();
            String finalStr = str.concat(secStr);
            


            Bundle bundle = new Bundle();
            bundle.putString("valueFromFrag",finalStr);
            getParentFragmentManager().setFragmentResult("value",bundle);
            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.funcToSecondFrag();
        }

        });




        return view;
    }


}