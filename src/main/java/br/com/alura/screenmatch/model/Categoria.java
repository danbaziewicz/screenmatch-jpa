package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action", "Ação"),
    AVENTURA("Adventure", "Aventura"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    ROMANCE("Romance", "Romance"),
    MUSICAL("Musical", "Musical"),
    TERROR("Horror", "Terror"),
    FICCAO("Science Fiction", "Ficcão"),
    BIOGRAFIA("Biography", "Biografia"),
    DOCUMENTARIO("Documentary", "Documentário"),
    FANTASIA("Fantasy", "Fantasia"),
    ANIMACAO("Animation", "Animação"),
    SUSPENSE("Thriller", "Suspense"),
    MISTERIO("Mystery", "Misterio"),;

    private String categoriaOmdb;

    private String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + text);
    }

    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria inválida: " + text);
    }
}
