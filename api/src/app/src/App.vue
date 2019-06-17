<template>
  <v-app>
    <Navigation/>
    <v-spacer />
    <v-content style="margin-left:240px; margin-right:50px">
      <router-view />
    </v-content>
  </v-app>
</template>

<script>
import Navigation from './components/Navigation'

export default {
  name: 'App',
  components: {
    Navigation
  },
  data () {
    return {
      //
    }
  }
}
</script>
