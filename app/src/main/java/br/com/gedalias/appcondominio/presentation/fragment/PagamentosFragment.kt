package br.com.gedalias.appcondominio.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.gedalias.appcondominio.R
import br.com.gedalias.appcondominio.adapter.PagamentosRecyclerAdapter
import br.com.gedalias.appcondominio.dto.InfoPagamentosDTO
import br.com.gedalias.appcondominio.service.ActionPagamentos
import br.com.gedalias.appcondominio.service.PagamentosService

class PagamentosFragment : Fragment() {
    private val pagamentosFacade = PagamentosService()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_pagamentos, container, false)
        val context = root.context
        val selectMes = root.findViewById<Spinner>(R.id.selectMes)
        val listPagamentos = root.findViewById<RecyclerView>(R.id.listPagamentos)

        selectMes.adapter = ArrayAdapter(context, R.layout.support_simple_spinner_dropdown_item, lisMeses())

        val adapter = PagamentosRecyclerAdapter(mutableListOf(), context)

        listPagamentos.adapter = adapter
        listPagamentos.layoutManager = LinearLayoutManager(context)

        pagamentosFacade.all(object: ActionPagamentos {
            override fun onReceive(pagamentos: List<InfoPagamentosDTO>) {
                pagamentos.forEach {
                    adapter.addPagamentos(it)
                }
                Log.i("Dados", adapter.itemCount.toString())
                adapter.notifyDataSetChanged()
            }
        })

        return root
    }

    private fun lisMeses(): List<String> {
        var meses: List<String> = mutableListOf()
        meses += "Janeiro"
        meses += "Fevereiro"
        meses += "Março"
        meses += "Abril"
        meses += "Maio"
        meses += "Junho"
        meses += "Julho"
        meses += "Agosto"
        meses += "Setembro"
        meses += "Outubro"
        meses += "Novembro"
        meses += "Dezembro"
        return meses
    }
}