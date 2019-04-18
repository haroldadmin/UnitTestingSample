package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.UsersRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal object UsersRepositoryTest : Spek({

    val usersRepository by memoized {
        mock<UsersRepository> {
            on { getUsersAsync() } doReturn CompletableDeferred(listOf(User.emptyUser()))
        }
    }

    describe("Users Repository Test") {
        it("should return list of one user") {
            val users = runBlocking { usersRepository.getUsersAsync().await() }
            assertEquals(1, users.size)
        }
    }
})