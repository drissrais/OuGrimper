CREATE SEQUENCE public.pays_id_seq;

CREATE TABLE public.pays (
                id INTEGER NOT NULL DEFAULT nextval('public.pays_id_seq'),
                nom VARCHAR(100) NOT NULL,
                CONSTRAINT pays_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.pays_id_seq OWNED BY public.pays.id;


CREATE SEQUENCE public.ville_id_seq;

CREATE TABLE public.ville (
                id INTEGER NOT NULL DEFAULT nextval('public.ville_id_seq'),
                nom VARCHAR(100) NOT NULL,
                pays INTEGER NOT NULL,
                CONSTRAINT ville_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.ville_id_seq OWNED BY public.ville.id;

CREATE SEQUENCE public.compte_utilisateur_id_seq;

CREATE TABLE public.compte_utilisateur (
                id INTEGER NOT NULL DEFAULT nextval('public.compte_utilisateur_id_seq'),
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(100) NOT NULL,
                civilite VARCHAR(20) NOT NULL,
                date_de_naissance DATE NOT NULL,
                email VARCHAR(200) NOT NULL,
                role VARCHAR(100) NOT NULL,
                pseudo VARCHAR(100) NOT NULL,
                mot_de_passe VARCHAR(100) NOT NULL,
                CONSTRAINT compte_utilisateur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.compte_utilisateur_id_seq OWNED BY public.compte_utilisateur.id;


CREATE TABLE public.proprietaire_topo (
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT proprietaire_topo_pk PRIMARY KEY (utilisateur_id)
);


CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                nom VARCHAR(150) NOT NULL,
                description VARCHAR(1000),
                localite VARCHAR(1000) NOT NULL,
                region VARCHAR(100) NOT NULL,
                photo VARCHAR(255),
                plan VARCHAR(255),
                ville_plus_proche INTEGER NOT NULL,
                pays INTEGER NOT NULL,
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.site.id;

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.topo (
                id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
                nom VARCHAR(200) NOT NULL,
                description VARCHAR(1000),
                disponible BOOLEAN NOT NULL,
                plan VARCHAR(255),
                proprietaire_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;

CREATE SEQUENCE public.reservation_id_seq;

CREATE TABLE public.reservation (
                id INTEGER NOT NULL DEFAULT nextval('public.reservation_id_seq'),
                utilisateur_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                statut VARCHAR(50),
                CONSTRAINT reservation_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.reservation_id_seq OWNED BY public.reservation.id;

CREATE SEQUENCE public.commentaire_site_id_seq;

CREATE TABLE public.commentaire_site (
                id INTEGER NOT NULL DEFAULT nextval('public.commentaire_site_id_seq'),
                utilisateur_id INTEGER NOT NULL,
                site_id INTEGER NOT NULL,
                contenu VARCHAR(1000) NOT NULL,
                date TIMESTAMP without time zone NOT NULL,
                CONSTRAINT commentaire_site_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.commentaire_site_id_seq OWNED BY public.commentaire_site.id;


CREATE SEQUENCE public.secteur_id_seq;

CREATE TABLE public.secteur (
                id INTEGER NOT NULL DEFAULT nextval('public.secteur_id_seq'),
                nom VARCHAR(100) NOT NULL,
                plan VARCHAR(255),
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;

CREATE SEQUENCE public.voie_id_seq;

CREATE TABLE public.voie (
                id INTEGER NOT NULL DEFAULT nextval('public.voie_id_seq'),
                nom VARCHAR(100) NOT NULL,
                nb_longueur INTEGER NOT NULL,
                cotation VARCHAR(20) NOT NULL,
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;

CREATE SEQUENCE public.longueur_id_seq;

CREATE TABLE public.longueur (
                id INTEGER NOT NULL DEFAULT nextval('public.longueur_id_seq'),
                verticalite VARCHAR(100) NOT NULL,
                nb_point INTEGER NOT NULL,
                voie_id INTEGER NOT NULL,
                cotation VARCHAR(20) NOT NULL,
                CONSTRAINT longueur_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;

ALTER TABLE public.ville ADD CONSTRAINT pays_ville_fk
FOREIGN KEY (pays)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT pays_site_fk
FOREIGN KEY (pays)
REFERENCES public.pays (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.site ADD CONSTRAINT ville_site_fk
FOREIGN KEY (ville_plus_proche)
REFERENCES public.ville (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT compte_utilisateur_commentaire_topo_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.compte_utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT compte_utilisateur_reservation_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.compte_utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_site ADD CONSTRAINT compte_utilisateur_commentaire_site_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.compte_utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT compte_utilisateur_topo_fk
FOREIGN KEY (proprietaire_id)
REFERENCES public.compte_utilisateur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_site ADD CONSTRAINT site_commentaire_site_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT site_topo_fk
FOREIGN KEY (site_id)
REFERENCES public.site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.reservation ADD CONSTRAINT topo_reservation_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.longueur ADD CONSTRAINT voie_longueur_fk
FOREIGN KEY (voie_id)
REFERENCES public.voie (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
