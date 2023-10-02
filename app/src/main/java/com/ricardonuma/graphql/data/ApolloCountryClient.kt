package com.ricardonuma.graphql.data

import com.apollographql.apollo3.ApolloClient
import com.ricardonuma.CountriesQuery
import com.ricardonuma.CountryQuery
import com.ricardonuma.graphql.domain.CountryClient
import com.ricardonuma.graphql.domain.DetailedCountry
import com.ricardonuma.graphql.domain.SimpleCountry

class ApolloCountryClient (
    private val apolloClient: ApolloClient
): CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}