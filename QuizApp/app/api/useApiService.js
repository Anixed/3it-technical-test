import ApiService from './ApiService';

export default function useApiService() {
  const apiService = new ApiService();
  return apiService;
}
