enum class PurchaseType(val info: String) {
    LEASE("리스"),
    RENT("장기렌트"),
    ALL("리스/렌트")
}

// base method override
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
            },
    TALKING{
        override fun signal() = WAITING
        };

    abstract fun signal(): ProtocolState
}

fun main() {
    println(PurchaseType.RENT.toString()) // RENT
    println(PurchaseType.LEASE.name) // LEASE
    println(PurchaseType.ALL.info) // 리스/렌트


    // valueOf(~~), values()
    println(PurchaseType.valueOf("LEASE")) // LEASE
    //println(PurchaseType.valueOf("LEESE")) // IllegalArgumentException 발생

    println(PurchaseType.values().joinToString()) // LEASE, RENT, ALL


    println("-----------------")

    println(ProtocolState.TALKING) // TALKING
    println(ProtocolState.TALKING.signal()) // WAITING
}