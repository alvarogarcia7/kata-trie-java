20150314-202322 AGB

pseudo-notation where λ represents nothing. in a trie, this nothing means the word is valid, i.e., end of word or \0 in C to indicate end of string

before + new element => after

	{} + a => {aλ}
{a} + ab => {a->{λ,b}}
{b} + a => {aλ, bλ}
{ab} + ab => {abλ}
{ab} + aba => {ab->{λ,a}}