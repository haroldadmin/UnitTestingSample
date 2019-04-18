package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe


internal object UsersViewModelTest: Spek({

    val usersRepository = mock<UsersRepository>()
    val viewModel by memoized { UsersViewModel(usersRepository) }
    val mainThreadSurrogate by memoized { newSingleThreadContext("UI Thread") }
    describe("UsersViewModelTest") {

        before {
            Dispatchers.setMain(mainThreadSurrogate)
        }

        it("Should fetch users when initialized") {
            runBlocking(viewModel.coroutineContext) {
                verify(usersRepository, times(1)).getUsersAsync()
            }
        }

        after {
            Dispatchers.resetMain()
            mainThreadSurrogate.close()
        }
    }

})