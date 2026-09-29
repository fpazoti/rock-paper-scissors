# Rock-Paper-Scissors — Reasoning Log

Level 1 of the mentorship program: entities, value objects, and invariants.
Domain: a rock-paper-scissors game between two people, later evolved into the
lizard/Spock variant.

## The three hardest decisions

1. **Dropping the generic interface (`RockPaperScissors<T extends RockPaperScissors<T>>`)
   in favor of Template Method.** The self-bounded generics design solved the
   problem, but brought accidental complexity — it was hard to "see" and to
   justify the syntax. Template Method kept the same problem more readable: an
   abstract class concentrates what's common across variants, and each one
   only implements the part that changes.

2. **Keeping a `Player` class instead of working with `Move` alone.** The
   client made it clear the original problem was disputes over "who played
   what" — without keeping track of who made each move, the system wouldn't
   solve the reason it was requested in the first place.

3. **Putting the game variant (`RockPaperScissors`) in `Game`'s constructor,
   instead of receiving it as a parameter of `play()`.** This guarantees, at
   the object's creation, that both players will always be in the same
   variant — the same invariant protection already applied to the two
   `Player`s.

## Pattern that emerged

**Template Method.** `RockPaperScissors` concentrates everything that's common
across the game's variants (validating the move against the chosen variant,
delegating the decision of who won, translating the result into
`Optional<Player>`) inside a `final` method — the algorithm's skeleton can't be
altered by subclasses. `ClassicRockPaperScissors` and
`BigBangTheoryRockPaperScissors` only fill in the two points that actually vary
between variants: which moves exist, and the rule for who beats whom.

## What I'd do differently

Choosing this design pattern became clearer once I concretely noticed that
only a small part of the flow changed between cases, while the rest stayed
identical. Next time, that's the question I'd ask earlier: "what actually
changes between the cases, and is that really small compared to everything
that stays the same?"
