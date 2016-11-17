package yidinghe.android.playcardhelper.data

/**
 * Created by yidinghe on 11/16/16.
 */

data class User(val userName: String, val rank: Int, val score: Double, val imageUrl: String)

data class Avatar(val avatarName: AvatarName)

enum class UserAction {
    NEW_GAME, CONTINUE, RANK, HELP, ABOUT
}

enum class AvatarName {
    BIRD, CAT, CHICKEN, DOG, DUCK, FISH, GOAT, HIPPO, HORSE, LAMB, LION, MONKEY, MOUSE, OWL, PIG, REDPANDA, TIGER, WOLF
}