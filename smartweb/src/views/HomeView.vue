<template>
  <div class="home">
    <h1>获取用户信息</h1>
    <button @click="getUserInfo">点击获取用户信息</button>

    <div v-if="user">
      <p>姓名: {{ user.name }}</p>
      <p>年龄: {{ user.age }}</p>
    </div>

    <div v-if="error" style="color:red">{{ error }}</div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
import http from '../api/http'

interface User {
  name: string
  age: number
}

const user = ref<User | null>(null)
const error = ref<string>('')

async function getUserInfo() {
  try {
    error.value = ''
    const res = await http.get<User>('/user')
    user.value = res.data
  } catch (err: any) {
    error.value = '请求失败，请稍后重试'
    console.error(err)
  }
}
</script>

<style scoped>
.home {
  text-align: center;
  padding: 50px;
}
button {
  margin-bottom: 20px;
  padding: 8px 16px;
}
</style>
