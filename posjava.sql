PGDMP     0    ,                 y            posjava    12.5    12.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    posjava    DATABASE     �   CREATE DATABASE posjava WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE posjava;
                postgres    false            �            1259    16394    userposjava    TABLE     �   CREATE TABLE public.userposjava (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL,
    email character varying(255) NOT NULL
);
    DROP TABLE public.userposjava;
       public         heap    postgres    false                       0    16394    userposjava 
   TABLE DATA           6   COPY public.userposjava (id, nome, email) FROM stdin;
    public          postgres    false    202   �       
           2606    16403    userposjava unique_email 
   CONSTRAINT     T   ALTER TABLE ONLY public.userposjava
    ADD CONSTRAINT unique_email UNIQUE (email);
 B   ALTER TABLE ONLY public.userposjava DROP CONSTRAINT unique_email;
       public            postgres    false    202            �
           2606    16401    userposjava user_pk 
   CONSTRAINT     Q   ALTER TABLE ONLY public.userposjava
    ADD CONSTRAINT user_pk PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.userposjava DROP CONSTRAINT user_pk;
       public            postgres    false    202                _   x�3��M,JN��Wp�/JI�,�WpJ,�����̅H$'A�鹉�9z���\F�A���9�
�U�����9
)�
ΉEe�9��E`�d(I[� �'�     