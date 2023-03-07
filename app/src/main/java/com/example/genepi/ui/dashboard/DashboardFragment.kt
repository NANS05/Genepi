package com.example.genepi.ui.dashboard

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.genepi.R
import com.example.genepi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    class language(val id : Int) {
        var value : Int = 0
    }
    private var languageTable = listOf(
        language(0),
        language(1),
        language(2),
        language(3),
        language(4),
        language(5),
        language(6),
        language(7),
        language(8),
        language(9),
    )

//    var languageTable = IntArray(10)
//    class languageTable {
//        var c : Int = 0
//        var javascript : Int = 0
//        var kotlin : Int = 0
//        var python : Int = 0
//        var swift : Int = 0
//        var give_up : Int = 0
//        var csharp : Int = 0
//        var cpp : Int = 0
//        var php : Int = 0
//        var golang : Int = 0
//
//    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        var yesButton = binding.mainButtonForm
        yesButton.setBackgroundColor(Color.GREEN)
        var noButton = binding.mainButtonForm2
        noButton.setBackgroundColor(Color.RED)
        var question = binding.question
        var questionCount = 0
        var result = binding.result

        val langageResult = arrayOf(
            resources.getString(R.string.c_language),
            resources.getString(R.string.javascript),
            resources.getString(R.string.kotlin),
            resources.getString(R.string.python),
            resources.getString(R.string.swift),
            resources.getString(R.string.give_up),
            resources.getString(R.string.csharp),
            resources.getString(R.string.cpp),
            resources.getString(R.string.php),
            resources.getString(R.string.golang)
        )

        val questionTable = arrayOf(
            resources.getString(R.string.text_form_q0),
            resources.getString(R.string.text_form_q1),
            resources.getString(R.string.text_form_q2),
            resources.getString(R.string.text_form_q3),
            resources.getString(R.string.text_form_q4),
            resources.getString(R.string.text_form_q5),
            resources.getString(R.string.text_form_q6),
            resources.getString(R.string.text_form_q7),
            resources.getString(R.string.text_form_q8),
            resources.getString(R.string.text_form_q9)
        )
        question.text = questionTable[questionCount]
                //formButton.enable = false;

        yesButton.setOnClickListener {
            if (questionCount < 9) {
                response(1, questionCount)
                result.text = langageResult[languageTable.maxOf {it.value}]
                questionCount++
                question.text = questionTable[questionCount]
            }
        }
        noButton.setOnClickListener {
            if (questionCount < 9) {
                response(0, questionCount)
                result.text = langageResult[languageTable.maxOf {it.value}]
                questionCount++
                question.text = questionTable[questionCount]
            }
        }

        return root
    }

    private fun hapiness(boolean: Int){
        languageTable[0].value += boolean
        languageTable[7].value += boolean
        languageTable[6].value += boolean
        languageTable[1].value -= boolean
    }
    private fun humanity(boolean: Int) {
        languageTable[1].value += boolean
        languageTable[2].value += boolean
        languageTable[3].value += boolean
        languageTable[4].value += boolean
        languageTable[5].value += boolean
        languageTable[6].value += boolean
        languageTable[9].value += boolean
        languageTable[7].value -= boolean
        languageTable[0].value -= boolean
    }
    private fun androidoman(boolean: Int) {
        if (boolean == 0 ) {
            languageTable[4].value += boolean
            languageTable[2].value -= boolean
        }
        else  {
            languageTable[4].value -= boolean
            languageTable[2].value += boolean
        }

    }
    private fun family(boolean: Int) {
        languageTable[5].value += boolean
        languageTable[0].value += boolean
    }
    private fun friends(boolean: Int) {
        languageTable[5].value += boolean
    }
    private fun countman(boolean: Int) {
        languageTable[3].value += boolean
        languageTable[0].value += boolean
        languageTable[7].value += boolean
    }
    private fun rich(boolean: Int) {
        languageTable[2].value += boolean
        languageTable[9].value += boolean
        languageTable[6].value += boolean
    }
    private fun sum(boolean: Int) {
        languageTable[0].value += boolean
        languageTable[7].value += boolean
        languageTable[9].value += boolean
        languageTable[8].value += boolean
    }
    private fun tie(boolean: Int) {
        languageTable[9].value += boolean
        languageTable[8].value += boolean
        languageTable[0].value += boolean
        languageTable[5].value += boolean
    }
    private fun threeByThree(boolean: Int) {
        languageTable[9].value += boolean
        languageTable[8].value += boolean
        languageTable[5].value += boolean
        languageTable[0].value += boolean
    }
    private fun response(boolean: Int, int: Int) {
        when (int) {
            0 -> hapiness(boolean)
            1 -> humanity(boolean)
            2 -> androidoman(boolean)
            3 -> family(boolean)
            4 -> friends(boolean)
            5 -> countman(boolean)
            6 -> rich(boolean)
            7 -> sum(boolean)
            8 -> tie(boolean)
            9 -> threeByThree(boolean)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

//private operator fun <T> Array<T>.get(maxBy: DashboardFragment.language): T {

//}
