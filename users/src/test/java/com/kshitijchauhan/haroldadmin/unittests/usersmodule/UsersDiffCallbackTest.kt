package com.kshitijchauhan.haroldadmin.unittests.usersmodule

import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Address
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.Company
import com.kshitijchauhan.haroldadmin.json_placeholder_repository.models.User
import com.kshitijchauhan.haroldadmin.unittests.usersmodule.UsersDiffCallback
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

internal object UsersDiffCallbackTest: Spek({
    describe("Users DiffCallback test") {
        val callback by memoized { UsersDiffCallback() }

        describe("Compare same users") {

            it("returns true when checking if items are same") {
                assertTrue(callback.areItemsTheSame(User.emptyUser(), User.emptyUser()))
            }

            it("returns true when checking if contents are same") {
                assertTrue(callback.areContentsTheSame(User.emptyUser(), User.emptyUser()))
            }
        }

        describe("Compare different users") {
            val user1 by memoized { User(1, "User 1", "", "", Address.emptyAddress(), "", "", Company.emptyCompany()) }
            val user2 by memoized { User(2, "User 2", "", "", Address.emptyAddress(), "", "", Company.emptyCompany()) }

            it("returns false when checking if items are same") {
                assertFalse(callback.areItemsTheSame(user1, user2))
            }

            it("returns false when checking if contents are the same") {
                assertFalse(callback.areContentsTheSame(user1, user2))
            }
        }
    }
})