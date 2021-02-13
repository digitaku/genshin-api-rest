# Unir Tabelas

@ManyToMany(cascade = {
CascadeType.PERSIST,
CascadeType.MERGE
})
@JoinTable(name = "post_tag",
joinColumns = @JoinColumn(name = "post_id"),
inverseJoinColumns = @JoinColumn(name = "tag_id")
)

@ManyToMany(mappedBy = "tags")
tags e nome do atributo na outra classe

## tabelas

passive talents and ability status

## rotas

- personagem
- item
- get outras
- update

## repositories

## secure

## exceptions
