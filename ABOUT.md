# Unir Tabelas many to many

@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
@JoinTable(name = "post_tag", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "
tag_id")
)

@ManyToMany(mappedBy = "tags")
tags e nome do atributo na outra classe


## models(falta)

- passive talents and ability status
- adicionar imagem em alguns models

## dto

- todos -users

## rotas(falta)

- todas -personagem,item
- busca do banco por nome

## repositories
- interface para services ?
- busca do banco por nome

## services

## secure

- jwt
- validação
- autorização

## exceptions

- Forbidden
- Unauthorized
