    val lambda: (Long, Long) -> Long = { from: Long, to: Long ->
        (from..to).reduce { a, b -> a * b }
    }
