<template>
  <div class="login">
    <h1>用户登录</h1>
    <input v-model="username" placeholder="用户名" />
    <input v-model="password" type="password" placeholder="密码" />
    <button @click="login">登录</button>

    <p v-if="message" :style="{color: messageColor}">{{ message }}</p>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import http from '../api/http'

const username = ref('')
const password = ref('')
const message = ref('')
const messageColor = ref('red')
const router = useRouter()

async function login() {
  try {
    const res = await http.post('/login', {
      username: username.value,
      password: password.value
    })
    if (res.data.status === 'success') {
      message.value = res.data.message
      messageColor.value = 'green'
      router.push('/home')
    } else {
      message.value = res.data.message
      messageColor.value = 'red'
    }
  } catch (err) {
    console.error(err)
    message.value = '请求失败'
    messageColor.value = 'red'
  }
}
</script>

<style scoped>
.login {
  max-width: 400px;
  margin: 50px auto;
  text-align: center;
}
input {
  display: block;
  width: 100%;
  margin-bottom: 10px;
  padding: 8px;
}
button {
  padding: 8px 16px;
}
</style>
