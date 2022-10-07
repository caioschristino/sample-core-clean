package com.v2.sample.clean

import com.v2.sample.clean.feature.landing.domain.Landing
import com.v2.sample.clean.feature.landing.domain.Pokemon
import java.time.LocalDate
import java.util.*
import java.util.concurrent.ThreadLocalRandom

class DataFactory {
    companion object Factory {

        fun randomUuid() = UUID.randomUUID().toString()

        private fun randomInt() = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

        private fun randomDouble() = randomInt().toDouble()

        private fun randomLong() = randomInt().toLong()

        private fun randomDate() = LocalDate.ofEpochDay(randomLong())

        private fun randomBoolean() = Math.random() < 0.5

        fun mockLanding() = Landing(randomInt(), randomUuid(), mockPokemonList())

        fun mockEmptyLanding() = Landing(randomInt(), randomUuid(), mutableListOf())

        fun mockPokemon() = Pokemon(randomUuid(), randomUuid(), randomBoolean())

        fun mockPokemonList() = (0..10).map { mockPokemon() }.toMutableList()
    }
}