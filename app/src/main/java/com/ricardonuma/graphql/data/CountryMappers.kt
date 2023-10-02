package com.ricardonuma.graphql.data

import com.ricardonuma.CountriesQuery
import com.ricardonuma.CountryQuery
import com.ricardonuma.graphql.domain.DetailedCountry
import com.ricardonuma.graphql.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name,
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji
    )
}