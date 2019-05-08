package pe.edu.upc.esfuerzo2.network

import pe.edu.upc.esfuerzo2.models.Source

class SourcesResponse(val sources: List<Source>?) : NewsApiResponse() {
    constructor() : this(ArrayList<Source>())
}