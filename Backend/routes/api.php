<?php

use App\Http\Controllers\AccountController;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});
Route::prefix('accounts')->group(function () {
    Route::get('/', [AccountController::class, 'index']); // Lấy danh sách accounts
    Route::post('/', [AccountController::class, 'store']); // Thêm mới account
    Route::get('/{id}', [AccountController::class, 'show']); // Xem thông tin account
    Route::put('/{id}', [AccountController::class, 'update']); // Cập nhật account
    Route::delete('/{id}', [AccountController::class, 'destroy']); // Xóa account
});
