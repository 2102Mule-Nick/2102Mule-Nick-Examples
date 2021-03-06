PGDMP     '    9        	        y            postgres    13.0    13.0      !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            $           1262    13442    postgres    DATABASE     l   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            %           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3108            �            1259    16749    cart    TABLE     l   CREATE TABLE public.cart (
    cart_id integer NOT NULL,
    user_id integer,
    total double precision
);
    DROP TABLE public.cart;
       public         heap    postgres    false            �            1259    16747    cart_cart_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cart_cart_id_seq;
       public          postgres    false    231            &           0    0    cart_cart_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cart_cart_id_seq OWNED BY public.cart.cart_id;
          public          postgres    false    230            �            1259    16760 	   cart_item    TABLE     w   CREATE TABLE public.cart_item (
    cart_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer
);
    DROP TABLE public.cart_item;
       public         heap    postgres    false            �            1259    16727    item    TABLE     �   CREATE TABLE public.item (
    product_id integer NOT NULL,
    item_cost double precision,
    item_name text,
    remining_items integer,
    discount double precision
);
    DROP TABLE public.item;
       public         heap    postgres    false            �            1259    16725    item_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.item_product_id_seq;
       public          postgres    false    227            '           0    0    item_product_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.item_product_id_seq OWNED BY public.item.product_id;
          public          postgres    false    226            �            1259    16738    user_acc    TABLE     f   CREATE TABLE public.user_acc (
    user_id integer NOT NULL,
    username text,
    pass_word text
);
    DROP TABLE public.user_acc;
       public         heap    postgres    false            �            1259    16736    user_acc_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_acc_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.user_acc_user_id_seq;
       public          postgres    false    229            (           0    0    user_acc_user_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.user_acc_user_id_seq OWNED BY public.user_acc.user_id;
          public          postgres    false    228            �           2604    16752    cart cart_id    DEFAULT     l   ALTER TABLE ONLY public.cart ALTER COLUMN cart_id SET DEFAULT nextval('public.cart_cart_id_seq'::regclass);
 ;   ALTER TABLE public.cart ALTER COLUMN cart_id DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    16730    item product_id    DEFAULT     r   ALTER TABLE ONLY public.item ALTER COLUMN product_id SET DEFAULT nextval('public.item_product_id_seq'::regclass);
 >   ALTER TABLE public.item ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    16741    user_acc user_id    DEFAULT     t   ALTER TABLE ONLY public.user_acc ALTER COLUMN user_id SET DEFAULT nextval('public.user_acc_user_id_seq'::regclass);
 ?   ALTER TABLE public.user_acc ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    229    228    229                      0    16749    cart 
   TABLE DATA           7   COPY public.cart (cart_id, user_id, total) FROM stdin;
    public          postgres    false    231                      0    16760 	   cart_item 
   TABLE DATA           B   COPY public.cart_item (cart_id, product_id, quantity) FROM stdin;
    public          postgres    false    232                      0    16727    item 
   TABLE DATA           Z   COPY public.item (product_id, item_cost, item_name, remining_items, discount) FROM stdin;
    public          postgres    false    227                      0    16738    user_acc 
   TABLE DATA           @   COPY public.user_acc (user_id, username, pass_word) FROM stdin;
    public          postgres    false    229            )           0    0    cart_cart_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cart_cart_id_seq', 26, true);
          public          postgres    false    230            *           0    0    item_product_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.item_product_id_seq', 130, true);
          public          postgres    false    226            +           0    0    user_acc_user_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.user_acc_user_id_seq', 34, true);
          public          postgres    false    228            �           2606    16764    cart_item cart_item_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_pkey PRIMARY KEY (cart_id, product_id);
 B   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_pkey;
       public            postgres    false    232    232            �           2606    16754    cart cart_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);
 8   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_pkey;
       public            postgres    false    231            �           2606    16735    item item_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (product_id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    227            �           2606    16746    user_acc user_acc_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.user_acc
    ADD CONSTRAINT user_acc_pkey PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.user_acc DROP CONSTRAINT user_acc_pkey;
       public            postgres    false    229            �           2606    16765     cart_item cart_item_cart_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_cart_id_fkey FOREIGN KEY (cart_id) REFERENCES public.cart(cart_id);
 J   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_cart_id_fkey;
       public          postgres    false    232    2957    231            �           2606    16770 #   cart_item cart_item_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.item(product_id);
 M   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_product_id_fkey;
       public          postgres    false    232    2953    227            �           2606    16755    cart cart_user_id_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_acc(user_id);
 @   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_user_id_fkey;
       public          postgres    false    2955    231    229               L   x�%��	�@��d�b���]���*�FJD�4[ڭ�_���z�UC��p��r�r&�Yf|����         �   x�5�� B�X̎�h�����uO�d�`!�
aAd�7�͉pL�h����I��s!�����l�J�x��s?��e��%nl�;d�9��wl�Ǜ7�I�
v��������8��H�+&l^��c�P'	ק�(�jN����<�$�S�淋���2�           x�MTێ�8}.��_� c?N�����ֶZ�2/�	
`d���|�����I"+�ʧNݐ%U��YW�[��8�`ITd��Z���I|��t(�ʤ$Y�3��Ko\a�2�55��[m�܍�񶢦������l�T��y����?�E�+��t ��|5��2G�s2�m����Lj&}~����b�����d��ʚ�)�fIQ�
���3;R�H�f��zÒ ����0_Rx�|ͼ�@�,�݄�F{���S��8�����_��:��T�F��͹~���Ԝږ��$�kM&,ƛ�=�wå�p�VT��y3_lH��ʈ.�����td�5�C�qrsvEuC�u�lF�uwhHF��۵�j��I3�d�k*W�5�Q�0���ކޚ=<�������5x&��cS^�"����s���y8�\eZ2���:t7;��M]�r^�4�L���8p�:7߷F�&�w��c/�����OVd�e��`��+Fh�0����T'�DL�9R�HG����e�MP��g7^���e�潵�?"e~����")��A�qUm�8�ȍ��쭵oȑ�vq���Fs���� �eΨ��C7��%}�#�,6C[���	��(��j+�6��j:'Z�x�lD��X?U��N6��t��>��6cX�Z�'�*�*��|�f?�9��5X�݈���Q>���3�=��v��x���~u�`$�T��ŷر';q7b8������a�� �z�q6 [7�RcI�.��R&!��=_����)�f��g�e�o�LX         �   x�]�1�0���c��8*&��..�V[�=R¿W'���^.���ЮLca��,�Ku&��{��g���A7�2ղܱ0�&_[�.��d�����ΠU)0���i�t��`�,VE�AH�D�9ڦw��q���]�ˠ�1����>�*2+�0X�cU���=�c<O�$�  \��           !           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            "           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            #           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            $           1262    13442    postgres    DATABASE     l   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            %           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3108            �            1259    16749    cart    TABLE     l   CREATE TABLE public.cart (
    cart_id integer NOT NULL,
    user_id integer,
    total double precision
);
    DROP TABLE public.cart;
       public         heap    postgres    false            �            1259    16747    cart_cart_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cart_cart_id_seq;
       public          postgres    false    231            &           0    0    cart_cart_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cart_cart_id_seq OWNED BY public.cart.cart_id;
          public          postgres    false    230            �            1259    16760 	   cart_item    TABLE     w   CREATE TABLE public.cart_item (
    cart_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer
);
    DROP TABLE public.cart_item;
       public         heap    postgres    false            �            1259    16727    item    TABLE     �   CREATE TABLE public.item (
    product_id integer NOT NULL,
    item_cost double precision,
    item_name text,
    remining_items integer,
    discount double precision
);
    DROP TABLE public.item;
       public         heap    postgres    false            �            1259    16725    item_product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.item_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.item_product_id_seq;
       public          postgres    false    227            '           0    0    item_product_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.item_product_id_seq OWNED BY public.item.product_id;
          public          postgres    false    226            �            1259    16738    user_acc    TABLE     f   CREATE TABLE public.user_acc (
    user_id integer NOT NULL,
    username text,
    pass_word text
);
    DROP TABLE public.user_acc;
       public         heap    postgres    false            �            1259    16736    user_acc_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.user_acc_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.user_acc_user_id_seq;
       public          postgres    false    229            (           0    0    user_acc_user_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.user_acc_user_id_seq OWNED BY public.user_acc.user_id;
          public          postgres    false    228            �           2604    16752    cart cart_id    DEFAULT     l   ALTER TABLE ONLY public.cart ALTER COLUMN cart_id SET DEFAULT nextval('public.cart_cart_id_seq'::regclass);
 ;   ALTER TABLE public.cart ALTER COLUMN cart_id DROP DEFAULT;
       public          postgres    false    230    231    231            �           2604    16730    item product_id    DEFAULT     r   ALTER TABLE ONLY public.item ALTER COLUMN product_id SET DEFAULT nextval('public.item_product_id_seq'::regclass);
 >   ALTER TABLE public.item ALTER COLUMN product_id DROP DEFAULT;
       public          postgres    false    226    227    227            �           2604    16741    user_acc user_id    DEFAULT     t   ALTER TABLE ONLY public.user_acc ALTER COLUMN user_id SET DEFAULT nextval('public.user_acc_user_id_seq'::regclass);
 ?   ALTER TABLE public.user_acc ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    229    228    229                      0    16749    cart 
   TABLE DATA           7   COPY public.cart (cart_id, user_id, total) FROM stdin;
    public          postgres    false    231                    0    16760 	   cart_item 
   TABLE DATA           B   COPY public.cart_item (cart_id, product_id, quantity) FROM stdin;
    public          postgres    false    232   V                  0    16727    item 
   TABLE DATA           Z   COPY public.item (product_id, item_cost, item_name, remining_items, discount) FROM stdin;
    public          postgres    false    227   �                  0    16738    user_acc 
   TABLE DATA           @   COPY public.user_acc (user_id, username, pass_word) FROM stdin;
    public          postgres    false    229          )           0    0    cart_cart_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cart_cart_id_seq', 26, true);
          public          postgres    false    230            *           0    0    item_product_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.item_product_id_seq', 130, true);
          public          postgres    false    226            +           0    0    user_acc_user_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.user_acc_user_id_seq', 34, true);
          public          postgres    false    228            �           2606    16764    cart_item cart_item_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_pkey PRIMARY KEY (cart_id, product_id);
 B   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_pkey;
       public            postgres    false    232    232            �           2606    16754    cart cart_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);
 8   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_pkey;
       public            postgres    false    231            �           2606    16735    item item_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pkey PRIMARY KEY (product_id);
 8   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pkey;
       public            postgres    false    227            �           2606    16746    user_acc user_acc_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.user_acc
    ADD CONSTRAINT user_acc_pkey PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.user_acc DROP CONSTRAINT user_acc_pkey;
       public            postgres    false    229            �           2606    16765     cart_item cart_item_cart_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_cart_id_fkey FOREIGN KEY (cart_id) REFERENCES public.cart(cart_id);
 J   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_cart_id_fkey;
       public          postgres    false    232    2957    231            �           2606    16770 #   cart_item cart_item_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.item(product_id);
 M   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_product_id_fkey;
       public          postgres    false    232    2953    227            �           2606    16755    cart cart_user_id_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_acc(user_id);
 @   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_user_id_fkey;
       public          postgres    false    2955    231    229           