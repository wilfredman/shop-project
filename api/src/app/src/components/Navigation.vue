<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-navigation-drawer
            stateless
            value="true"
            dark
            fixed
            width="230"

    >

        <v-list v-for="item in items"
                :key="item.title"
                @click=""
                :to="item.path">

            <v-list-group v-if="item.submenu">
                <template v-slot:activator>
                    <v-list-tile>
                        <v-list-tile-action>
                            <v-icon>{{ item.icon }}</v-icon>
                        </v-list-tile-action>
                        <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                    </v-list-tile>
                </template>

                <v-list-tile
                        v-for="sub in item.submenu"
                        :key="sub.title"
                        @click=""
                        :to="sub.path"
                >
                    <v-list-tile-title>{{ sub.title }}</v-list-tile-title>
                    <v-list-tile-action>
                        <v-icon>{{ sub.icon }}</v-icon>
                    </v-list-tile-action>
                </v-list-tile>

            </v-list-group>

            <v-list-tile @click=""
                         :to="item.path"
                         v-else>
                <v-list-tile-action>
                    <v-icon>{{ item.icon }}</v-icon>
                </v-list-tile-action>
                <v-list-tile-content>
                    <v-list-tile-title>{{ item.title }}</v-list-tile-title>
                </v-list-tile-content>
            </v-list-tile>


        </v-list>
    </v-navigation-drawer>
</template>
<script>
    export default {
        data: () => ({
            items: [
                { title: 'Home', icon: 'home', path:'/' },
                { title: '상품', icon: 'local_offer', submenu: [
                        { title: '전체 목록', icon: 'list', path:'/product' }
                    ]
                },
                { title: '장바구니', icon: 'shopping_cart', path:'/cart'}
            ]
        })
    }
</script>
