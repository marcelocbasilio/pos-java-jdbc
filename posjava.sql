PGDMP     	    2                y            posjava    12.5    12.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    posjava    DATABASE     �   CREATE DATABASE posjava WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE posjava;
                postgres    false            �            1259    24588    user_telefone_seq    SEQUENCE     z   CREATE SEQUENCE public.user_telefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.user_telefone_seq;
       public          postgres    false            �            1259    24578    telefoneuser    TABLE     �   CREATE TABLE public.telefoneuser (
    id bigint DEFAULT nextval('public.user_telefone_seq'::regclass) NOT NULL,
    numero character varying(20) NOT NULL,
    tipo character varying(20) NOT NULL,
    usuariopessoa bigint NOT NULL
);
     DROP TABLE public.telefoneuser;
       public         heap    postgres    false    204            �            1259    24590    userposjava_seq    SEQUENCE     x   CREATE SEQUENCE public.userposjava_seq
    START WITH 3
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.userposjava_seq;
       public          postgres    false            �            1259    16394    userposjava    TABLE     �   CREATE TABLE public.userposjava (
    id bigint DEFAULT nextval('public.userposjava_seq'::regclass) NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255) NOT NULL
);
    DROP TABLE public.userposjava;
       public         heap    postgres    false    205                      0    24578    telefoneuser 
   TABLE DATA           G   COPY public.telefoneuser (id, numero, tipo, usuariopessoa) FROM stdin;
    public          postgres    false    203   �                 0    16394    userposjava 
   TABLE DATA           6   COPY public.userposjava (id, nome, email) FROM stdin;
    public          postgres    false    202   �                  0    0    user_telefone_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.user_telefone_seq', 1, true);
          public          postgres    false    204                       0    0    userposjava_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.userposjava_seq', 3, true);
          public          postgres    false    205            �
           2606    24582    telefoneuser telefone_id 
   CONSTRAINT     V   ALTER TABLE ONLY public.telefoneuser
    ADD CONSTRAINT telefone_id PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.telefoneuser DROP CONSTRAINT telefone_id;
       public            postgres    false    203            �
           2606    16403    userposjava unique_email 
   CONSTRAINT     T   ALTER TABLE ONLY public.userposjava
    ADD CONSTRAINT unique_email UNIQUE (email);
 B   ALTER TABLE ONLY public.userposjava DROP CONSTRAINT unique_email;
       public            postgres    false    202            �
           2606    16401    userposjava user_pk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.userposjava
    ADD CONSTRAINT user_pk PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.userposjava DROP CONSTRAINT user_pk;
       public            postgres    false    202            �
           2606    24577    userposjava userposjava_id_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.userposjava
    ADD CONSTRAINT userposjava_id_key UNIQUE (id);
 H   ALTER TABLE ONLY public.userposjava DROP CONSTRAINT userposjava_id_key;
       public            postgres    false    202            �
           2606    24583 ,   telefoneuser telefoneuser_usuariopessoa_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.telefoneuser
    ADD CONSTRAINT telefoneuser_usuariopessoa_fkey FOREIGN KEY (usuariopessoa) REFERENCES public.userposjava(id);
 V   ALTER TABLE ONLY public.telefoneuser DROP CONSTRAINT telefoneuser_usuariopessoa_fkey;
       public          postgres    false    2699    202    203                  x������ � �         c   x�3�J��̩Tp�J-,�L�QHIUpN,*K����,�%C�鹉�9z���\����Eɩ9�
��E)��E�
N�Ň��d�s�Bd���3�|$]1z\\\ FH(�     