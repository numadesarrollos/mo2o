package com.example.mo2o.data.responses

import com.example.mo2o.data.Recepy

data class RecepyResponse (val title:String, val version:String, val href:String,val results: List<Recepy>)